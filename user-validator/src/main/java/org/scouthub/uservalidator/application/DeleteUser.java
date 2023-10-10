package org.scouthub.uservalidator.application;

import org.scouthub.uservalidator.domain.service.UserService;

public class DeleteUser {
  private DeleteUser() {}

  public static void delete(Long id, UserService userService) {
    userService.deleteUser(id);
  }
}
