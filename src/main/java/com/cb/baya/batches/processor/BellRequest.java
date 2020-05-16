package com.cb.baya.batches.processor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BellRequest {

  private int bellId;
}
