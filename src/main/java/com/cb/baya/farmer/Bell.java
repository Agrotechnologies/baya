package com.cb.baya.farmer;

import com.cb.baya.common.BaseEntity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Bell extends BaseEntity {

  private int bellWeight;
  private String classification;
  @OneToOne
  @JoinColumn(name = "farmer_id", referencedColumnName = "id")
  private Farmer farmer;

}
