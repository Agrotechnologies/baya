package com.cb.baya.batches;

import com.cb.baya.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data

public class BatchesDto extends BaseDto implements Serializable {

  private String batchNo;
  private int totalEstimateWeight;
  private BatchStatus batchStatus;
}
