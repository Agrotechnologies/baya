package com.cb.baya.location;

import com.cb.baya.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class DistrictDto extends BaseDto implements Serializable {
  private String name;
  private int totalWards;
}
