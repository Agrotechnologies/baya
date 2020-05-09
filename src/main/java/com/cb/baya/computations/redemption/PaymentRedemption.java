package com.cb.baya.computations.redemption;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.serviceweights.SubscriberWeights;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_redemption")
@Getter
@Setter
@ToString
public class PaymentRedemption extends BaseEntity {

  @Column(name = "redemption_date")
  private LocalDateTime redemptionDate;

  @ToString.Exclude
  @ManyToOne
  private SubscriberWeights subscriberWeights;

  @Column(name = "phone_number")
  private String msisdn;

  @Column(name = "balance_before", nullable = false)
  private BigDecimal balanceBefore;

  @Column(name = "balance_redeemed", nullable = false)
  private BigDecimal balanceRedeemed;

  @Column(name = "balance_after", nullable = false)
  private BigDecimal balanceAfter;

}
