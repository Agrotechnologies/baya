package com.cb.baya.transport;

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

public class TransportServiceImpl implements TransportService {

  private final TransportRepository transportRepository;

  @Override
  public Transport register(Transport transport) {

    log.info("Register Transporter :{}", transport);
    return transportRepository.save(transport);
  }

  @Override
  public Optional<Transport> findByRegNumber(String regNumber) {
    return transportRepository.findByRegNumber(regNumber);
  }

  @Override
  public Optional<Transport> findById(long id) {
    return transportRepository.findById(id);
  }

  @Override
  public Long total() {
    return transportRepository.count();
  }

  @Override
  public Transport update(Transport transport) {
    return transportRepository.save(transport);
  }

  @Override
  public List<Transport> findAll(Pageable pageable) {
    return transportRepository.findAll(pageable).getContent();
  }
}
