package com.cb.baya.transport.driver;

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
public class DriverServiceImpl implements DriverService {

  private final DriverRepository driverRepository;

  @Override
  public Driver register(Driver driver) {

    log.info("Register Driver :{}", driver);
    return driverRepository.save(driver);
  }

  @Override
  public Optional<Driver> findByDriverLicenceNo(String driverLicenceNo) {
    return driverRepository.findByDriverLicenceNo(driverLicenceNo);
  }

  @Override
  public Optional<Driver> findByMsisdn(String msisdn) {

    return driverRepository.findByMsisdn(msisdn);
  }

  @Override
  public Optional<Driver> findById(long id) {

    return driverRepository.findById(id);
  }

  @Override
  public List<Driver> findBySurname(String surname) {
    return driverRepository.findBySurname(surname);
  }

  @Override
  public List<Driver> findByName(String name) {
    return driverRepository.findByName(name);
  }

  @Override
  public Long total() {
    return driverRepository.count();
  }

  @Override
  public Driver update(Driver driver) {

    log.info("Register Driver :{}", driver);
    return driverRepository.save(driver);
  }

  @Override
  public List<Driver> findAll(Pageable pageable) {
    return driverRepository.findAll(pageable).getContent();
  }
}
