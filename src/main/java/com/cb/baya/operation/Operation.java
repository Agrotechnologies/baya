package com.cb.baya.operation;


import com.cb.baya.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "service_type")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
public class Operation extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "cost_per_trip")
  private BigDecimal costPerTrip;

}
