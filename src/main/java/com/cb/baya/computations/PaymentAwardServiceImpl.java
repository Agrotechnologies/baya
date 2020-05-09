package com.cb.baya.computations;

import com.cb.baya.exception.BusinessException;
import com.cb.baya.job.JobRequest;
import com.cb.baya.operation.Operation;
import com.cb.baya.operation.OperationService;
import com.cb.baya.parameter.ParameterName;
import com.cb.baya.parameter.ParameterService;
import com.cb.baya.serviceweights.SubscriberWeights;
import com.cb.baya.serviceweights.SubscriberWeightsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@Slf4j
public class PaymentAwardServiceImpl implements PaymentAwardService {

  private final PaymentAwardRepository paymentAwardRepository;
  private final OperationService operationService;
  private final ParameterService parameterService;
  private final SubscriberWeightsService subscriberWeightsService;

  @Override
  public PaymentCredit save(PaymentCredit paymentCredit) {
    return paymentAwardRepository.save(paymentCredit);
  }

  @Override
  public List<PaymentCredit> findByMsisdn(String msisdn) {
    return paymentAwardRepository.findByMsisdn(msisdn);
  }

  @Override
  public PaymentCredit allocatePoints(JobRequest jobRequest) {

    final Operation operation = operationService.findById(jobRequest.getOperation().getId())
      .orElseThrow(() -> new BusinessException("Could not find service type " + jobRequest.getOperation().getName()));

    final BigDecimal transPortCostToField = getTransportCostToField(jobRequest);
    final BigDecimal points = (operation.getCostPerTrip().multiply(jobRequest.getEstimatedWeight())).add(transPortCostToField);
    final PaymentCredit paymentCredit = buildPointsAward(jobRequest, points);
    return this.save(paymentCredit);
  }

  private PaymentCredit buildPointsAward(JobRequest jobRequest, BigDecimal paymentCredited) {
    log.info("build points award for subscriber {} , job request {}", jobRequest.getMsisdn(), jobRequest);
    final SubscriberWeights subscriberWeights = subscriberWeightsService.findByMsisdn(jobRequest.getServiceProvider().getMsisdn())
      .orElseThrow(() -> new BusinessException("subscriber is not registered for this service"));
    final PaymentCredit paymentCredit = new PaymentCredit();
    paymentCredit.setCreditDate(LocalDateTime.now());
    paymentCredit.setJobRequest(jobRequest);
    paymentCredit.setMsisdn(jobRequest.getMsisdn());
    paymentCredit.setBalanceBefore(subscriberWeights.getWeightsDone());
    paymentCredit.setBalanceAfter(subscriberWeights.getWeightsDone().add(paymentCredited));
    paymentCredit.setBalanceCredit(paymentCredited);
    subscriberWeights.setWeightsDone(subscriberWeights.getWeightsDone().add(paymentCredited));
    subscriberWeights.setTotalBells(subscriberWeights.getTotalBells().add(jobRequest.getNumberOfBells()));
    return paymentCredit;
  }

  private BigDecimal getTransportCostToField(JobRequest jobRequest) {
    final BigDecimal transportCostPerKm = parameterService.getParameterValue(ParameterName.TRANSPORT_COST_PER_KM, BigDecimal.class);
    return transportCostPerKm.multiply(jobRequest.getDistanceToJob());
  }
}
