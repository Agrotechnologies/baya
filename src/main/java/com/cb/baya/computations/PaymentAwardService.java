package com.cb.baya.computations;

import com.cb.baya.job.JobRequest;

import java.util.List;

public interface PaymentAwardService {

  PaymentCredit save(PaymentCredit paymentCredit);

  List<PaymentCredit> findByMsisdn(String msisdn);

  PaymentCredit allocatePoints(JobRequest jobRequest);


}
