package org.scouthub.apiuser.application;

import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

public final class CreateUser {
  public static void create(User user, UserRepository userRepository) {
    userRepository.save(user);
  }
}
