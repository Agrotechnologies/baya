package com.cb.baya.serviceimplement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRED)
@Slf4j
public class ServiceImplementServiceImpl implements ServiceImplementService {

  private final ServiceImplementRepository implementRepository;

//    @Override
//    public Optional<TractorImplement> findByRegistrationNumber(String registrationNumber) {
//        return tractorRepository.findByRegistrationNumber(registrationNumber);
//    }


  @Override
  public List<ServiceImplement> findByServiceProviderMsisdn(String msisdn) {
    return null;
  }

  @Override
  public List<ServiceImplement> findAll(int pageCount) {

    final Pageable pageable = PageRequest.of(0, pageCount);
    return implementRepository.findAll(pageable).getContent();
  }

  @Override
  public List<ServiceImplement> findAll() {
    return implementRepository.findAll();
  }

  @Override
  public ServiceImplement register(ServiceImplement serviceImplement) {
    return implementRepository.save(serviceImplement);
  }

  @Override
  public ServiceImplement update(ServiceImplement serviceImplement) {
    return implementRepository.save(serviceImplement);
  }


}
