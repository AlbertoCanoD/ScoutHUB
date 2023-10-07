package org.scouthub.usersender.infraestructure.rest.controller;

import io.swagger.annotations.ApiOperation;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;
import org.scouthub.usersender.infraestructure.rest.dto.UserDeleteRequestDTO;

public interface UserController {
  @ApiOperation(value = "Create a user")
  void createUser(UserRequestDTO userRequestDTO);

  @ApiOperation(value = "Delete a user")
  void deleteUser(UserDeleteRequestDTO userDeleteRequestDTO);
}
