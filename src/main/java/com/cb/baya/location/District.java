package com.cb.baya.location;


import com.cb.baya.common.BaseEntity;
import com.cb.baya.job.JobRequest;
import com.cb.baya.tsp.ServiceProvider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "district", indexes = {@Index(name = "id", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
