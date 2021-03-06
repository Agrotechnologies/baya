package com.cb.baya.transport;

import com.cb.baya.common.BaseDto;
import com.cb.baya.location.DistrictDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransportDto extends BaseDto implements Serializable {

  private String name;
  private String firstName;
  private String lastName;
  private int number_of_trucks;
  private DistrictDto district;

}
