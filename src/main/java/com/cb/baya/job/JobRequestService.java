package com.cb.baya.job;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface JobRequestService {
  JobRequest createJobRequest(JobRequest jobRequest);

  JobRequest updateJobRequest(JobRequest jobRequest);

  void deleteJobRequest(JobRequest jobRequest);

  List<JobRequest> findByMsisdn(String msisdn);

  Optional<JobRequest> findById(Long id);

  Long getNumberOfJobs();

  List<JobRequest> findAll(Pageable pageable);

  List<JobRequest> search(String search, int page, Integer size, Sort by) throws InterruptedException;
}
