package com.cb.baya.payments;

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
@Transactional(propagation = Propagation.REQUIRED)
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;

  @Override
  public Payment save(Payment payment) {
    return paymentRepository.save(payment);
  }

  @Override
  public Payment update(Payment payment) {
    return null;
  }

  @Override
  public List<Payment> findEligibleRewards(BigDecimal points) {
    return paymentRepository.findByQualifyingPointsLessThanEqual(points);
  }

  @Override
  public Optional<Payment> findByPrizeName(String prizeName) {

    return paymentRepository.findByPrizeName(prizeName);
  }

  @Override
  public Optional<Payment> findById(Long id) {

    return paymentRepository.findById(id);
  }

  @Override
  public void delete(Payment payment) {
    return;
  }

//    @Override
//    public List<Reward> findAll(Integer page, Integer size, String sortBy) {
//        return rewardRepository.findAll(PageRequest.of(--page, size, Sort.by(sortBy))).getContent();
//    }

  @Override
  public Long total() {
    return paymentRepository.count();
  }

  @Override
  public List<Payment> findAll(Pageable pageable) {
    return paymentRepository.findAll(pageable).getContent();
  }
}
