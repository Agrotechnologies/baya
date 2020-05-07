package com.cb.baya.job;

import com.cb.baya.common.BaseDto;
import com.cb.baya.location.DistrictDto;
import com.cb.baya.operation.OperationDto;
import com.cb.baya.tsp.ServiceProviderDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class JobRequestDto extends BaseDto implements Serializable {
  private String firstName;
  private String lastName;
  private BigDecimal hectrage;
  private String scheme;
  private DistrictDto district;
  private OperationDto operation;
  private String msisdn;
  private BigDecimal distanceToJob;
  private JobStatus status;
  private Date jobDate;
  private ServiceProviderDto serviceProviderDto;
}
