package com.cb.baya.serviceimplement;

import com.cb.baya.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceImplementDto extends BaseDto implements Serializable {
  private String name;
  private int capacity;

}
