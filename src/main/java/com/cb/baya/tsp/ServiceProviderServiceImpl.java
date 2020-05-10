package com.cb.baya.tsp;


import com.cb.baya.serviceweights.SubscriberWeights;
import com.cb.baya.serviceweights.SubscriberWeightsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceProviderServiceImpl implements ServiceProviderService {

  private final ServiceProviderRepository providerRepository;
  private final SubscriberWeightsService subscriberWeightsService;

  @Override
  public ServiceProvider register(ServiceProvider serviceProvider) {
    log.info("Register TSP :{}", serviceProvider);
    final SubscriberWeights subscriberWeights = new SubscriberWeights();
    subscriberWeights.setTotalBells(BigDecimal.ZERO);
    subscriberWeights.setMsisdn(serviceProvider.getMsisdn());
    subscriberWeights.setStage(Stage.STAGE_1);
    subscriberWeights.setWeightsDone(BigDecimal.ZERO);
    subscriberWeightsService.save(subscriberWeights);
    serviceProvider.setSubscriberWeights(subscriberWeights);
    return providerRepository.save(serviceProvider);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ServiceProvider> findByMsisdn(String msidn) {
    return providerRepository.findByMsisdn(msidn);
  }

  @Override
  public Optional<ServiceProvider> findById(long id) {
    return providerRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ServiceProvider> findByLastName(String lastName) {
    return providerRepository.findByLastName(lastName);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ServiceProvider> findByFirstName(String firstName) {
    return providerRepository.findByFirstName(firstName);
  }

  @Override
  @Transactional(readOnly = true)
  public Long total() {
    return providerRepository.count();
  }

  @Override
  public ServiceProvider update(ServiceProvider serviceProvider) {

    return providerRepository.save(serviceProvider);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ServiceProvider> findAll(Pageable pageable) {
    return providerRepository.findAll(pageable).getContent();
  }

}
