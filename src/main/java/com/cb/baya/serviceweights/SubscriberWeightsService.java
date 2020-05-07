package com.cb.baya.serviceweights;

import java.util.Optional;

public interface SubscriberWeightsService {

  SubscriberWeights save(SubscriberWeights subscriberWeights);

  Optional<SubscriberWeights> findByMsisdn(String msisdn);

  SubscriberWeights update(String msisdn, int points);

}
