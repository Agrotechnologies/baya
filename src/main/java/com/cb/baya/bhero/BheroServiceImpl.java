package com.cb.baya.bhero;

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

public class BheroServiceImpl implements BheroService {

  private final BheroRepository bheroRepository;

  @Override
  public Bhero register(Bhero bhero) {
    log.info("Register Bhero :{}", bhero);
    return bheroRepository.save(bhero);
  }

  @Override
  public Optional<Bhero> findByBellNo(int bellNo) {
    return bheroRepository.findByBellNo(bellNo);
  }

  @Override
  public Optional<Bhero> findById(long id) {
    return bheroRepository.findById(id);
  }

  @Override
  public List<Bhero> findByClassification(String classsification) {
    return bheroRepository.findByClassification(classsification);
  }

  @Override
  public List<Bhero> findByBellStatus(String bellStatus) {

    return bheroRepository.findByBellStatus(bellStatus);
  }

  @Override
  public Long total() {
    return bheroRepository.count();
  }

  @Override
  public Bhero update(Bhero bhero) {
    return bheroRepository.save(bhero);
  }

  @Override
  public List<Bhero> findAll(Pageable pageable) {
    return bheroRepository.findAll(pageable).getContent();
  }
}
