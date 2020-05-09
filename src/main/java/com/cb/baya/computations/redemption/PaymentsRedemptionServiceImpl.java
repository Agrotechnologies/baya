package com.cb.baya.computations.redemption;

import com.cb.baya.computations.redemption.data.PaymentRequest;
import com.cb.baya.computations.redemption.data.PaymentsResponse;
import com.cb.baya.config.TypeMapper;
import com.cb.baya.exception.BusinessException;
import com.cb.baya.exception.RewardNotFoundException;
import com.cb.baya.payments.Payment;
import com.cb.baya.payments.PaymentService;
import com.cb.baya.serviceweights.SubscriberWeights;
import com.cb.baya.serviceweights.SubscriberWeightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class PaymentsRedemptionServiceImpl implements PaymentsRedemptionService {

  private final PaymentsRedemptionRepository redemptionRepository;
  private final SubscriberWeightsService subscriberWeightsService;
  private final PaymentService paymentService;
  private final TypeMapper mapper;

  @Override
  public List<PaymentRedemption> findByMsisdn(String msisdn) {
    return redemptionRepository.findByMsisdn(msisdn);
  }

  @Override
  public PaymentRedemption save(PaymentRedemption paymentRedemption) {
    return redemptionRepository.save(paymentRedemption);
  }

  @Override
  public PaymentsResponse redeem(PaymentRequest paymentRequest) {

    final SubscriberWeights subscriberWeights = subscriberWeightsService.findByMsisdn(paymentRequest.getMsisdn())
      .orElseThrow(() -> new BusinessException("Subscriber is not registered for this service"));
//        final Reward reward = rewardService.findByPrizeName(redemptionRequest.getPrizeName())
//                .orElseThrow(() -> new RewardNotFoundException("Could not find reward with name " + redemptionRequest.getPrizeName()));
    final Payment payment = paymentService.findById(paymentRequest.getPayment().getId())
      .orElseThrow(() -> new RewardNotFoundException("Could not find reward with id " + paymentRequest.getPayment().getId()));
    final PaymentsResponse paymentsResponse = new PaymentsResponse();
    paymentsResponse.setMsisdn(paymentRequest.getMsisdn());
    if (subscriberWeights.getWeightsDone().compareTo(payment.getQualifyingPoints()) >= 0) {
      final PaymentRedemption paymentRedemption = buildPointsRedemption(paymentRequest, subscriberWeights, payment);
      redemptionRepository.save(paymentRedemption);
      subscriberWeights.setWeightsDone(subscriberWeights.getWeightsDone().subtract(paymentRedemption.getBalanceRedeemed()));
      subscriberWeightsService.save(subscriberWeights);
      paymentsResponse.setMessage("Successful");
      paymentsResponse.setPointsAfter(subscriberWeights.getWeightsDone());
      paymentsResponse.setSuccessful(Boolean.TRUE);
      paymentsResponse.setReward(mapper.map(payment));
      return paymentsResponse;
    }
    paymentsResponse.setSuccessful(Boolean.FALSE);
    paymentsResponse.setMessage("Insufficient points");
    return paymentsResponse;
  }

  private PaymentRedemption buildPointsRedemption(PaymentRequest paymentRequest, SubscriberWeights subscriberPoints, Payment payment) {

    final PaymentRedemption paymentRedemption = new PaymentRedemption();
    paymentRedemption.setMsisdn(subscriberPoints.getMsisdn());
    paymentRedemption.setBalanceBefore(subscriberPoints.getWeightsDone());
    paymentRedemption.setBalanceRedeemed(payment.getQualifyingPoints());
    paymentRedemption.setBalanceAfter(subscriberPoints.getWeightsDone().subtract(payment.getQualifyingPoints()));
    paymentRedemption.setRedemptionDate(LocalDateTime.now());
    return paymentRedemption;
  }
}
