package com.cb.baya.farmer.bell;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.farmer.Farmer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Bell extends BaseEntity {

  @Column(name = "bell_weight")
  private int bellWeight;
  @Column(name = "classification", length = 9, unique = true, nullable = false)
  private String classification;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "farmer_id", referencedColumnName = "id")
  private Farmer farmer;

}
