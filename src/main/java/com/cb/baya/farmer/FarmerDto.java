package com.cb.baya.farmer;

import com.cb.baya.common.BaseDto;
import com.cb.baya.location.DistrictDto;
import lombok.Data;

import java.io.Serializable;

@Data

public class FarmerDto extends BaseDto implements Serializable {

  private String msisdn;
  private String growerNo;
  private String firstName;
  private String lastName;
  private DistrictDto district;
  private String latitude;
  private String longitude;
  private String village;

}
