package org.scouthub.usersender.infraestructure.rest.controller;

import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;
import org.scouthub.usersender.infraestructure.rest.dto.UserDeleteRequestDTO;

public interface UserController {
  void createUser(UserRequestDTO userRequestDTO);

  void deleteUser(UserDeleteRequestDTO userDeleteRequestDTO);
}
