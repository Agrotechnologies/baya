package com.cb.baya.tsp;


import com.cb.baya.common.BaseEntity;
import com.cb.baya.job.JobRequest;
import com.cb.baya.location.District;
import com.cb.baya.serviceimplement.ServiceImplement;
import com.cb.baya.serviceweights.SubscriberWeights;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscribers", indexes = {@Index(name = "indx_subscriber_msisdn", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
public class ServiceProvider extends BaseEntity {

  @Column(name = "msisdn", length = 50, unique = true, nullable = false)
  private String msisdn;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "number_of_trucks")
  private int number_of_trucks;

  @ManyToOne(fetch = FetchType.EAGER)
  private District district;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<ServiceImplement> serviceImplements;

  @ToString.Exclude
  @OneToMany(mappedBy = "serviceProvider")
  private List<JobRequest> jobRequests;

  @OneToOne
  @JoinColumn(name = "subscriber_weights_id", referencedColumnName = "id")
  private SubscriberWeights subscriberWeights;

}
