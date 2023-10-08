package org.scouthub.usersender.application;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.domain.service.UserService;

@Slf4j
public final class CreateUser {
  private CreateUser() {}

  public static void create(User user, UserService userService) {
    if (user == null) {
      log.error("User is null");
      return;
    }

    log.debug("Sending user {} to kafka topic", user.getId());
    userService.createUser(user);
  }
}
