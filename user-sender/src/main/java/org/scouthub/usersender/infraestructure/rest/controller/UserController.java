package org.scouthub.usersender.infraestructure.rest.controller;

import org.scouthub.usersender.infraestructure.rest.dto.UserDeleteRequestDTO;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;

public interface UserController {
  //@ApiOperation(value = "Create a user")
  void createUser(UserRequestDTO userRequestDTO);

  //@ApiOperation(value = "Delete a user")
  void deleteUser(UserDeleteRequestDTO userDeleteRequestDTO);
}
