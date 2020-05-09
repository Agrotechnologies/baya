package com.cb.baya.computations.redemption;

import com.cb.baya.computations.redemption.data.PaymentRequest;
import com.cb.baya.computations.redemption.data.PaymentsResponse;

import java.util.List;

public interface PaymentsRedemptionService {

  List<PaymentRedemption> findByMsisdn(String msisdn);

  PaymentRedemption save(PaymentRedemption paymentRedemption);

  PaymentsResponse redeem(PaymentRequest paymentRequest);
}
