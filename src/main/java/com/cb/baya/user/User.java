/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.baya.user;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Access(AccessType.FIELD)
public class User extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles;

}
