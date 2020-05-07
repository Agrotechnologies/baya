package com.cb.baya.market;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.market.commodity.Commodity;

import java.util.List;

public class Market extends BaseEntity {
  private String marketName;
  private String marketDescription;
  private List<Commodity> commodity;

}
