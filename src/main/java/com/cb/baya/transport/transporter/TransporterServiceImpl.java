package com.cb.baya.transport.transporter;

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

public class TransporterServiceImpl implements TransporterService {

  private final TransporterRepository transporterRepository;

  @Override
  public Transporter register(Transporter transporter) {

    log.info("Register Transporter :{}", transporter);
    return transporterRepository.save(transporter);
  }

  @Override
  public Optional<Transporter> findByMsisdn(String msidn) {
    return transporterRepository.findByMsisdn(msidn);
  }

  @Override
  public Optional<Transporter> findById(long id) {
    return transporterRepository.findById(id);
  }

  @Override
  public List<Transporter> findByLastName(String lastName) {
    return transporterRepository.findByLastName(lastName);
  }

  @Override
  public List<Transporter> findByFirstName(String firstName) {
    return transporterRepository.findByFirstName(firstName);
  }

  @Override
  public Long total() {
    return transporterRepository.count();
  }

  @Override
  public Transporter update(Transporter transporter) {
    return transporterRepository.save(transporter);
  }

  @Override
  public List<Transporter> findAll(Pageable pageable) {
    return transporterRepository.findAll(pageable).getContent();
  }
}
