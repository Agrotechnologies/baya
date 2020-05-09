package com.cb.baya.computations.redemption;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentsRedemptionRepository extends JpaRepository<PaymentRedemption, Long> {

  List<PaymentRedemption> findByMsisdn(String msisdn);
}
