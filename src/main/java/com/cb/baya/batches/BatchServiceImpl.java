package com.cb.baya.batches;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)

public class BatchServiceImpl implements BatchService {

  private final BatchesRepository batchesRepository;


  @Override
  public Batches register(Batches batches) {
    return batchesRepository.save(batches);
  }

  @Override
  public Optional<Batches> findByBatchNo(String batchNo) {
    return batchesRepository.findByBatchNo(batchNo);
  }

  @Override
  public List<Batches> findByBatchStatus(String batchStatus) {
    return batchesRepository.findByBatchStatus(batchStatus);
  }

  @Override
  public Optional<Batches> findById(long id) {
    return batchesRepository.findById(id);
  }

  @Override
  public Long total() {
    return batchesRepository.count();
  }

  @Override
  public Batches update(Batches batches) {
    return batchesRepository.save(batches);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Batches> findAll(Pageable pageable) {
    return batchesRepository.findAll(pageable).getContent();
  }
}
