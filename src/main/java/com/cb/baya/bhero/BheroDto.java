package com.cb.baya.bhero;

import com.cb.baya.batches.BatchesDto;
import com.cb.baya.common.BaseDto;
import com.cb.baya.farmer.FarmerDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BheroDto extends BaseDto implements Serializable {
  private int bellNo;
  private int bellWeight;
  private BellStatus bellStatus;
  private String classification;
  private FarmerDto farmer;
  private BatchesDto batches;

}
