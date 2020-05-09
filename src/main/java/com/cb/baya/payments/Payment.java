package com.cb.baya.payments;

import com.cb.baya.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
public class Payment extends BaseEntity {

  @Column(name = "prizeName", length = 200, nullable = false)
  private String prizeName;

  @Column(name = "prizeValue", nullable = false)
  private BigDecimal prizeValue;

  @Column(name = "qualifying_points", nullable = false)
  private BigDecimal qualifyingPoints;

}
