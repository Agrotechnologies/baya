package com.cb.baya.computations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentAwardRepository extends JpaRepository<PaymentCredit, Long> {

  List<PaymentCredit> findByMsisdn(String msisdn);
}
