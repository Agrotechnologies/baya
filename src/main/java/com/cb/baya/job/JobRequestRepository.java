package com.cb.baya.job;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JobRequestRepository extends PagingAndSortingRepository<JobRequest, Long> {

  List<JobRequest> findByMsisdn(String msisdn);


}
