package com.cb.baya.bhero;

import com.cb.baya.batches.Batches;
import com.cb.baya.common.BaseEntity;
import com.cb.baya.farmer.Farmer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bhero", indexes = {@Index(name = "indx_bero_id", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Bhero extends BaseEntity {

  @Column(name = "bell_no", unique = true)
  private int bellNo;
  @Column(name = "bell_weight")
  private int bellWeight;
  @Column(name = "bell_status")
  private BellStatus bellStatus;

  @Column(name = "classification", nullable = false)
  private String classification;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "farmers_id", nullable = false)
  @JsonIgnore
  private Farmer farmer;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "batches_id", nullable = false)
  @JsonIgnore
  private Batches batches;

}
