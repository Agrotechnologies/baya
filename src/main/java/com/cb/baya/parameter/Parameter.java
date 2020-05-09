package com.cb.baya.parameter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "parameter", indexes = {@Index(name = "indx_parameter_name", columnList = "name", unique = true)})
@Access(value = AccessType.FIELD)
@Getter
@Setter
public class Parameter implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", unique = true, length = 50)
  private String name;

  @Column(name = "val", length = 200, nullable = false)
  private String value;

  @Column(name = "user_can_edit")
  private boolean editable;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Parameter parameter = (Parameter) o;
    return Objects.equals(value, parameter.value);
  }

  @Override
  public int hashCode() {

    return Objects.hash(value);
  }
}
