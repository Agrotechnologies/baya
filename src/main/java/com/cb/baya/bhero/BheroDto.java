package com.cb.baya.bhero;

import com.cb.baya.common.BaseDto;
import com.cb.baya.farmer.FarmerDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class BheroDto extends BaseDto implements Serializable {
  private int bellNo;
  private int bellWeight;
  private BellStatus bellStatus;
  private String classification;
  private FarmerDto farmer;

}
