package com.cb.baya.farmer.bell;

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
public class BellServiceImpl implements BellService {

  private final BellRepository bellRepository;

  @Override
  public Bell register(Bell bell) {

    log.info("Register Bell :{}", bell);
    return bellRepository.save(bell);
  }

  @Override
  public Optional<Bell> findByClassification(String classification) {
    return bellRepository.findByClassification(classification);
  }

  @Override
  public Optional<Bell> findById(long id) {
    return bellRepository.findById(id);

  }

  @Override
  public Long total() {
    return bellRepository.count();
  }

  @Override
  public Bell update(Bell bell) {

    log.info("Register Bell :{}", bell);
    return bellRepository.save(bell);
  }

  @Override
  public List<Bell> findAll(Pageable pageable) {
    return bellRepository.findAll(pageable).getContent();
  }
}
