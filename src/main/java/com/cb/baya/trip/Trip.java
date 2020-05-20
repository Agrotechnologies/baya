package com.cb.baya.trip;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.transport.Transport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trips", indexes = {@Index(name = "indx_trip_id", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Trip extends BaseEntity {

  @Column(name = "number_of_bales", length = 50, unique = true, nullable = false)
  private int numberOfBales;

  @Column(name = "estimate_weight", length = 50, unique = true, nullable = false)
  private int estimateWeight;

  @OneToOne
  @JoinColumn(name = "transport_id", referencedColumnName = "id")
  private Transport transport;

  @Column(name = "stage", length = 25, unique = true, nullable = false)
  private TripStatus status;

  @Column(name = "start_date", length = 50, unique = true, nullable = false)
  private Date startDate;

  @Column(name = "end_date", length = 50, unique = true, nullable = false)
  private Date endDate;
}
