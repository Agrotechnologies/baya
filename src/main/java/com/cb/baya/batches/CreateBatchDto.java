package com.cb.baya.batches;

import com.cb.baya.bhero.BheroDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBatchDto {

  List<BheroDto> bheroList;
}
