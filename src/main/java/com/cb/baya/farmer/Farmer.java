package com.cb.baya.farmer;

import com.cb.baya.location.District;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import com.cb.baya.common.BaseEntity;

@Entity
@Table(name = "farmer", indexes = {@Index(name = "indx_farmer_msisdn", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)


public class Farmer extends BaseEntity {

  @Column(name = "growerNo", length = 9, unique = true, nullable = false)
  private String growerNo;

  @Column(name = "msisdn", length = 9, unique = true, nullable = false)
  private String msisdn;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "number_of_tractors")
  private int number_of_tractors;

  @ManyToOne(fetch = FetchType.EAGER)
  private District district;

  @Column(name = "longitude", length = 50, nullable = false)
  private String longitude;
  @Column(name = "latitude", length = 50, nullable = false)
  private String latitude;

  @Column(name = "village", length = 50, nullable = false)
  private String Village;

//  @ManyToMany(fetch = FetchType.LAZY)
//  private List<Bell> bells;

//  @ToString.Exclude
//  @OneToMany(mappedBy = "tractorServiceProvider")
//  private List<TransportRequest> jobRequests;
//
//
//  @OneToOne
//  @JoinColumn(name = "subscriber_points_id", referencedColumnName = "id")
//  private SubscriberPoints subscriberPoints;
}
