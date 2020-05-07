package com.cb.baya.serviceweights;

import com.cb.baya.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriberWeightsImpl implements SubscriberWeightsService {

  private final SubscriberWeightsRepository subscriberWeightsRepository;

  @Override
  public SubscriberWeights save(SubscriberWeights subscriberWeights) {
    return subscriberWeightsRepository.save(subscriberWeights);
  }

  @Override
  public Optional<SubscriberWeights> findByMsisdn(String msisdn) {
    return subscriberWeightsRepository.findByMsisdn(msisdn);
  }

  @Override
  public SubscriberWeights update(String msisdn, int points) {

    final Optional<SubscriberWeights> subscriberPointsOptional = subscriberWeightsRepository.findByMsisdn(msisdn);
    final SubscriberWeights subscriberWeights = subscriberPointsOptional.
      orElseThrow(() -> new BusinessException("Subscriber with msisdn " + msisdn + " not found"));
    final BigDecimal newPoints = subscriberWeights.getWeightsDone().add(new BigDecimal(points));
    subscriberWeights.setTotalBells(newPoints);
    //todo determine stage and update
    return subscriberWeightsRepository.save(subscriberWeights);
  }

}
