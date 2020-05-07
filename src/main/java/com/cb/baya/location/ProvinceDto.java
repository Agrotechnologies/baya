package com.cb.baya.location;

import com.cb.baya.common.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProvinceDto extends BaseDto implements Serializable {
  private String name;
  private List<DistrictDto> districts;
}
