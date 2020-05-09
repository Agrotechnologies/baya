package com.cb.baya.computations;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.job.JobRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@Table(name = "payment_credit", indexes = {@Index(name = "indx_payment_credit_msisdn", columnList = "msisdn")})
public class PaymentCredit extends BaseEntity {

  @Column(name = "msisdn", length = 9, nullable = false)
  private String msisdn;

  @Column(name = "balance_before", nullable = false)
  private BigDecimal balanceBefore;

  @Column(name = "payment_credit", nullable = false)
  private BigDecimal balanceCredit;

  @Column(name = "balance_after", nullable = false)
  private BigDecimal balanceAfter;

  @Column(name = "credit_date")
  private LocalDateTime creditDate;

  @ToString.Exclude
  @OneToOne(mappedBy = "job_request_credited")
  private JobRequest jobRequest;
}
