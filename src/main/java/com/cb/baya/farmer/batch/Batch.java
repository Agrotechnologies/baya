package com.cb.baya.farmer.batch;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.farmer.Bell;
import com.cb.baya.farmer.Farmer;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

public class Batch extends BaseEntity {
  private String batchNo;
  private String batchDescription;
  private List<Bell> bells;
  private int totalBells;
  private int estimateWeight;
  private int actualWeight;
  private int totalCost;
  @OneToOne
  @JoinColumn(name = "farmer_id", referencedColumnName = "id")
  private Farmer farmer;

}
