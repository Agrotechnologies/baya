package com.cb.baya.batches;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatchesRepository extends JpaRepository<Batches, Long> {

  Optional<Batches> findByBatchNo(String batchNo);

  List<Batches> findByBatchStatus(String batchStatus);


}
