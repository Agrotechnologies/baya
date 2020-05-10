package com.cb.baya.farmer;

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

public class FarmerServiceImpl implements FarmerService {

  private final FarmerRepository farmerRepository;

  @Override
  public Farmer register(Farmer farmer) {

    log.info("Register Farmer :{}", farmer);
    return farmerRepository.save(farmer);

  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Farmer> findByGrowerNo(String growerNo) {
    return farmerRepository.findByGrowerNo(growerNo);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Farmer> findByMsisdn(String msidn) {
    return farmerRepository.findByMsisdn(msidn);
  }

  @Override
  public Optional<Farmer> findById(long id) {
    return farmerRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Farmer> findByLastName(String lastName) {
    return farmerRepository.findByLastName(lastName);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Farmer> findByFirstName(String firstName) {
    return farmerRepository.findByFirstName(firstName);
  }

  @Override
  public Long total() {
    return farmerRepository.count();
  }

  @Override
  public Farmer update(Farmer farmer) {
    return farmerRepository.save(farmer);
  }

  @Override
  public List<Farmer> findAll(Pageable pageable) {
    return farmerRepository.findAll(pageable).getContent();
  }
}
