package org.scouthub.apiuser.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateUser {
  public static void create(User user, UserRepository userRepository) {
    userRepository.save(user);
  }
}
