
package com.cb.baya.user;

import com.cb.baya.common.BaseDto;
import com.cb.baya.role.RoleDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO extends BaseDto {

  protected String name;

  protected String username;

  protected String email;

  protected List<RoleDTO> roles;

}
