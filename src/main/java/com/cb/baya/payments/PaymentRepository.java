package com.cb.baya.payments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findByQualifyingPointsLessThanEqual(BigDecimal points);

  Optional<Payment> findByPrizeName(String prizeName);
}
