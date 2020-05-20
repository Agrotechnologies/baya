package com.cb.baya.transport;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.transport.driver.Driver;
import com.cb.baya.transport.transporter.Transporter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "transport", indexes = {@Index(name = "indx_trip_id", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Transport extends BaseEntity {

  @Column(name = "regNumber", length = 50, unique = true, nullable = false)
  private String regNumber;

  @Column(name = "capacity", length = 50, unique = false, nullable = false)
  private int capacity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "driver_id", nullable = false)
  @JsonIgnore
  private Driver driver;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "transporter_id", nullable = false)
  @JsonIgnore
  private Transporter transporter;


}
