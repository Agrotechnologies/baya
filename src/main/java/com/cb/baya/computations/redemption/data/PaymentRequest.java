package com.cb.baya.computations.redemption.data;

import com.cb.baya.payments.PaymentDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PaymentRequest implements Serializable {
  private BigDecimal weights;
  private String msisdn;
  private String prizeName;
  private PaymentDto payment;
}
