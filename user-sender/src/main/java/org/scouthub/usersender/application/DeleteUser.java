package org.scouthub.usersender.application;

import org.scouthub.usersender.domain.service.UserService;

public class DeleteUser {
  private DeleteUser() {}

  public static void delete(Long id, UserService userService) {
    userService.deleteUser(id);
  }
}
