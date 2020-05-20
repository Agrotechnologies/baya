package com.cb.baya.trip;

import com.cb.baya.common.BaseDto;
import com.cb.baya.transport.Transport;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TripDto extends BaseDto implements Serializable {

  private int numberOfBales;
  private int estimateWeight;
  private Transport transport;
  private TripStatus status;
  private Date startDate;
  private Date endDate;

}
