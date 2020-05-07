package com.cb.baya.job;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class PagedJobRequestDto implements Serializable {

  private List<JobRequestDto> jobRequests;
  private long numberOfJobs;


}
