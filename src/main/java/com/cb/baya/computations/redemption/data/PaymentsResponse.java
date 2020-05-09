package com.cb.baya.computations.redemption.data;


import com.cb.baya.payments.PaymentDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentsResponse implements Serializable {
  private Boolean successful;
  private String message;
  private BigDecimal pointsAfter;
  private String msisdn;
  private PaymentDto reward;
}
