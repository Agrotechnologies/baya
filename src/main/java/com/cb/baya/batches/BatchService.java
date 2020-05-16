package com.cb.baya.batches;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BatchService {

  Batches register(Batches batches);

  Optional<Batches> findByBatchNo(String batchNo);


  List<Batches> findByBatchStatus(String batchStatus);

  Optional<Batches> findById(long id);


  Long total();

  Batches update(Batches batches);

  List<Batches> findAll(Pageable pageable);
}
