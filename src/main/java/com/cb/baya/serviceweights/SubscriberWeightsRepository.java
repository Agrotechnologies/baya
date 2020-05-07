package com.cb.baya.serviceweights;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberWeightsRepository extends JpaRepository<SubscriberWeights, Long> {

  Optional<SubscriberWeights> findByMsisdn(String msisdn);
}
