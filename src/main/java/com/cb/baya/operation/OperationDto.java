package com.cb.baya.operation;

import com.cb.baya.common.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class OperationDto extends BaseDto implements Serializable {
  private String name;
  private BigDecimal costPerOp;
}
