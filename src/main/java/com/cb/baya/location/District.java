package com.cb.baya.location;


import com.cb.baya.common.BaseEntity;

import com.cb.baya.job.JobRequest;
import com.cb.baya.tsp.ServiceProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
public class District extends BaseEntity {

  @Column
  private String name;

  @Column
  private int totalWards;

  @ManyToOne
  private Province province;

  @ToString.Exclude
  @OneToMany(mappedBy = "district")
  private List<ServiceProvider> tractorServiceProviders;

  @ToString.Exclude
  @OneToMany(mappedBy = "district")
  private List<JobRequest> jobRequests;

}
