package com.cb.baya.trip;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.farmer.batch.Batch;
import com.cb.baya.serviceimplement.ServiceImplement;
import com.cb.baya.tsp.ServiceProvider;
import com.cb.baya.tsp.Stage;

import java.util.Date;
import java.util.List;

public class Trip extends BaseEntity {
  private int numberOfBales;
  private int estimateWeight;
  private List<Batch> batches;
  private ServiceProvider provider;
  private Stage stage;
  private ServiceImplement implement;
  private Date startDate;
  private Date endDate;


}
