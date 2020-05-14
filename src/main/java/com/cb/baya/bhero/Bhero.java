package com.cb.baya.bhero;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.farmer.Farmer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bhero", indexes = {@Index(name = "indx_bero_bellNo", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)

public class Bhero extends BaseEntity {

  @Column(name = "bell_no")
  private int bellNo;
  @Column(name = "bell_weight")
  private int bellWeight;
  @Column(name = "bell_status")
  private BellStatus bellStatus;

  @Column(name = "classification", length = 9, unique = true, nullable = false)
  private String classification;

  @ManyToOne(cascade = CascadeType.ALL)
  private Farmer farmer;

}
