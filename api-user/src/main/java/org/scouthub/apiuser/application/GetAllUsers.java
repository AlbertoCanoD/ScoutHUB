package org.scouthub.apiuser.application;

import java.util.List;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

public final class GetAllUsers {
  public static List<User> getAllUsers(UserRepository userRepository) {
    return userRepository.findAll();
  }
}
