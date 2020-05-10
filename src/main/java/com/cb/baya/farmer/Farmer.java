package com.cb.baya.farmer;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.location.District;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "farmers", indexes = {@Index(name = "indx_farmer_msisdn", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)


public class Farmer extends BaseEntity {

  @Column(name = "growerNo", length = 9, unique = true, nullable = false)
  private String growerNo;

  @Column(name = "msisdn", length = 50, unique = true, nullable = false)
  private String msisdn;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @ManyToOne(fetch = FetchType.EAGER)
  private District district;

  @Column(name = "longitude", length = 50, nullable = true)
  private String longitude;
  @Column(name = "latitude", length = 50, nullable = true)
  private String latitude;

  @Column(name = "village", length = 50, nullable = false)
  private String Village;


}
