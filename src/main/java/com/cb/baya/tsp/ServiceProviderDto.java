package com.cb.baya.tsp;

import com.cb.baya.common.BaseDto;
import com.cb.baya.location.DistrictDto;
import com.cb.baya.serviceimplement.ServiceImplementDto;
import com.cb.baya.serviceweights.SubscriberWeightsDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ServiceProviderDto extends BaseDto implements Serializable {
  private String msisdn;
  private String firstName;
  private String lastName;
  private DistrictDto district;
  private List<ServiceImplementDto> tractorImplements;
  private int number_of_implements;
  private SubscriberWeightsDto subscriberWeightsDto;

}
