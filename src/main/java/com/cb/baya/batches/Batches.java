package com.cb.baya.batches;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.trip.Trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "batches", indexes = {@Index(name = "indx_batches_batchId", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Batches extends BaseEntity {

  @Column(name = "batchNo", unique = true)
  private String batchNo;

  @Column(name = "total_weight")
  private int totalEstimateWeight;

  @Column(name = "batch_status")
  private BatchStatus batchStatus;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "trip_id", nullable = false)
  @JsonIgnore
  private Trip trip;

}
