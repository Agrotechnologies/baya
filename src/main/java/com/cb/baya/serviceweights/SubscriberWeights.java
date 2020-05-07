package com.cb.baya.serviceweights;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.tsp.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriber_weights")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
public class SubscriberWeights extends BaseEntity {

  @Column(name = "msisdn", nullable = false, unique = true)
  private String msisdn;

  @Column(name = "total_bells", nullable = false)
  private BigDecimal totalBells;

  @Column(name = "hectares_done", nullable = false)
  private BigDecimal weightsDone;

  @Column(name = "stage", nullable = false)
  private Stage stage;


}
