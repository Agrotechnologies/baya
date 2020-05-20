package com.cb.baya.transport.transporter;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.location.District;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "transporter", indexes = {@Index(name = "indx_transporter", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)

public class Transporter extends BaseEntity {

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

}
