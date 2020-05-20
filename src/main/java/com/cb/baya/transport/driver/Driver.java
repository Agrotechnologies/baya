package com.cb.baya.transport.driver;

import com.cb.baya.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "driver", indexes = {@Index(name = "indx_driver_id", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Driver extends BaseEntity {

  @Column(name = "driverName", length = 50, unique = false, nullable = false)
  private String name;

  @Column(name = "surname", length = 50, unique = false, nullable = false)
  private String surname;

  @Column(name = "msisdn", length = 12, unique = true, nullable = false)
  private String msisdn;

  @Column(name = "licence_no", length = 10, unique = true, nullable = false)
  private String driverLicenceNo;

}
