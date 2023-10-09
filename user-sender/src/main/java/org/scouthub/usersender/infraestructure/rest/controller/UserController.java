package org.scouthub.usersender.infraestructure.rest.controller;

import io.swagger.annotations.ApiOperation;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;

public interface UserController {
  // TODO - Add the ApiOperation que funcione
  @ApiOperation(value = "Create a user")
  void createUser(UserRequestDTO userRequestDTO);

  //  @ApiOperation(value = "Delete a user")
  //  void deleteUser(UserDeleteRequestDTO userDeleteRequestDTO);
}
