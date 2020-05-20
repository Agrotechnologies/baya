package com.cb.baya.transport.transporter;

import com.cb.baya.common.BaseDto;
import com.cb.baya.location.DistrictDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransporterDto extends BaseDto implements Serializable {

  private String msisdn;
  private String firstName;
  private String lastName;
  private int number_of_trucks;
  private DistrictDto district;

}
