package com.cb.baya.serviceimplement;

import com.cb.baya.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Access(AccessType.FIELD)
@Getter
@Setter
@ToString
@Table(name = "service_implement")
public class ServiceImplement extends BaseEntity {

  @Column(name = "name", length = 100)
  private String name;
  @Column(name = "capacity")
  private int capacity;


}
