package com.cb.baya.serviceweights;

import com.cb.baya.common.BaseDto;
import com.cb.baya.tsp.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SubscriberWeightsDto extends BaseDto implements Serializable {
  private String msisdn;
  private BigDecimal points;
  private Stage stage;
  private BigDecimal hectaresDone;
  private String firstName;
  private String lastName;
}
