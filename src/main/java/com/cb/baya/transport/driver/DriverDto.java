package com.cb.baya.transport.driver;

import com.cb.baya.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class DriverDto extends BaseDto implements Serializable {
  private String name;
  private String surname;
  private String msisdn;
  private String driverLicenceNo;

}
