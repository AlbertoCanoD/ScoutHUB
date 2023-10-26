package org.scouthub.usersender.infraestructure.rest.controller;

import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserController {
  void createUser(UserRequestDTO userRequestDTO);

  void deleteUser(@PathVariable Long userId);
}
