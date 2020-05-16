package com.cb.baya.batches.processor;

import com.cb.baya.batches.BatchSummary;
import com.cb.baya.batches.CreateBatchDto;
import com.cb.baya.bhero.Bhero;
import com.cb.baya.bhero.BheroDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class BatchProcessor {

  Bhero bhero = new Bhero();

  public BatchSummary createBatch(String username, CreateBatchDto createBatchDto) {

    List<Integer> bellIds = createBatchDto.getBheroList()
      .stream()
      .map(BheroDto::getBellNo).collect(Collectors.toList());

    Collections.sort(bellIds);
    BatchSummary batchSummary = new BatchSummary();
    return batchSummary;
  }


}
