package com.cb.baya.payments;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service

public interface PaymentService {

  Payment save(Payment payment);

  Payment update(Payment payment);

  List<Payment> findEligibleRewards(BigDecimal points);

  Optional<Payment> findByPrizeName(String prizeName);

  Optional<Payment> findById(Long id);

  void delete(Payment payment);

  //List<Reward> findAll(Integer page, Integer size, String sortBy);

  Long total();

  List<Payment> findAll(Pageable pageable);
}
