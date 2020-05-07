package com.cb.baya.job;

import com.cb.baya.exception.BusinessException;
import com.cb.baya.tsp.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static com.cb.baya.job.JobStatus.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class JobRequestServiceImpl implements JobRequestService {

  @PersistenceContext
  private EntityManager em;

  private final JobRequestRepository jobRequestRepository;
  private final PointsAwardService pointsAwardService;
  private final ServiceProviderService tractorServiceProviderService;

  @Override
  @Transactional
  public JobRequest createJobRequest(JobRequest jobRequest) {
    if (jobRequest.getId() != null) {
      new BusinessException("Security error : can not assign job id manually");
    }
    jobRequest.setStatus(JobStatus.CREATED);
    jobRequest.setDeleted(false);
    return jobRequestRepository.save(jobRequest);
  }

  @Override
  @Transactional
  public JobRequest updateJobRequest(JobRequest jobRequest) {
    log.info("Modify job request {}", jobRequest);
    jobRequest.setDeleted(false);
    final Optional<JobRequest> jobRequestOptional = jobRequestRepository.findById(jobRequest.getId());

    final JobRequest jobRequestOriginal = jobRequestOptional
      .orElseThrow(() -> new BusinessException("Job request with id " + jobRequest.getId() + " not found"));


//        if (jobRequestOriginal.getDeleted())
//            throw new BusinessException("Record is Deleted");
    // check current status of job if job is complete status should not be modifiable
    final JobStatus currentStatus = jobRequestOriginal.getStatus();
    final JobStatus presentedStatus = jobRequest.getStatus();
    int statusChange = findJobStatusValue(presentedStatus) - findJobStatusValue(currentStatus);

    if (currentStatus == COMPLETED) {
      throw new BusinessException("Cannot update job. Job " + jobRequest.getId() + " is completed");
    }

    if (currentStatus == CANCELLED) {
      throw new BusinessException("Cannot update job. Job " + jobRequest.getId() + " is cancelled");
    }

    if (statusChange == 1) {
      switch (presentedStatus) {
        case COMPLETED:
          pointsAwardService.allocatePoints(jobRequest);
          jobRequest.setStatus(COMPLETED);
          break;
        case ASSIGNED:
          assignJobToServiceProvider(jobRequest);
          break;
        default:
          break;
      }

    }

    return jobRequestRepository.save(jobRequest);
  }

  private void assignJobToServiceProvider(JobRequest jobRequest) {
    jobRequest.setTractorServiceProvider(jobRequest.getTractorServiceProvider());
    jobRequest.setStatus(ASSIGNED);
  }

  @Override
  public void deleteJobRequest(JobRequest jobRequest) {
    jobRequest.setDeleted(true);
    jobRequestRepository.save(jobRequest);
  }


  @Override
  @Transactional(readOnly = true)
  public List<JobRequest> findByMsisdn(String msisdn) {
    List<JobRequest> byMsisdn = jobRequestRepository.findByMsisdn(msisdn);
    byMsisdn.removeIf(job -> job.getDeleted());
    return byMsisdn;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<JobRequest> findById(Long id) {

    Optional<JobRequest> byId = jobRequestRepository.findById(id);
    JobRequest jobRequest = byId.orElseThrow(
      () -> new BusinessException("Job Request Not Found")
    );
//        if (jobRequest.getDeleted())
//            throw new BusinessException("Record Deleted");
    return byId;
  }

//    @Override
//    @Transactional(readOnly = true)
//    public List<JobRequest> findAll(int page, int size, String sortBy) {
//
//        final Pageable paging = PageRequest.of(--page, size, Sort.by(sortBy));
//        return jobRequestRepository.findAll(paging).getContent();
//    }

  @Override
  public Long getNumberOfJobs() {
    return jobRequestRepository.count();
  }

  @Override
  @Transactional(readOnly = true)
  public List<JobRequest> findAll(Pageable pageable) {
    return jobRequestRepository.findAll(pageable).getContent();
  }

  @Override
  public List<JobRequest> search(String search, int page, Integer size, Sort by) throws InterruptedException {
    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
    fullTextEntityManager.createIndexer().startAndWait();
    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
      .buildQueryBuilder().forEntity(JobRequest.class).get();
    org.apache.lucene.search.Query luceneQuery = queryBuilder
      .keyword()
      .onFields("firstName", "lastName", "msisdn")
      .matching(search)
      .createQuery();

    // wrap Lucene query in a javax.persistence.Query
    javax.persistence.Query jpaQuery =
      fullTextEntityManager.createFullTextQuery(luceneQuery, JobRequest.class);

//        jpaQuery.setMaxResults(size);
//        jpaQuery.setFirstResult(page);

    // execute search
    return jpaQuery.getResultList();
  }

  private int findJobStatusValue(JobStatus jobStatus) {
    switch (jobStatus) {
      case CREATED:
        return 0;
      case ASSIGNED:
        return 1;
      case COMPLETED:
        return 2;
      default:
        return -9999999;
    }
  }

}
