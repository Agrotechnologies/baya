package com.cb.baya.payments;

import com.cb.baya.common.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PaymentDto extends BaseDto implements Serializable {
  private String prizeName;
  private BigDecimal prizeValue;
  private BigDecimal qualifyingPoints;
}
