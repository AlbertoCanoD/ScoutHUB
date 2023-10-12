package org.scouthub.apiuser.application;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAllUsers {
  public static List<User> get(UserRepository userRepository) {
    return userRepository.findAll();
  }
}
