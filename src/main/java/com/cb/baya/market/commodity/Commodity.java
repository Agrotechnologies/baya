package com.cb.baya.market.commodity;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.market.price.Price;
import lombok.ToString;

import javax.persistence.OneToMany;
import java.util.List;

public class Commodity extends BaseEntity {
  private String commodityName;
  private String commodityDescription;
  private String clasification;
  private String grade;
  @ToString.Exclude
  @OneToMany(mappedBy = "price")
  private List<Price> price;
}
