package org.scouthub.apiuser.application;

import org.scouthub.apiuser.domain.exception.UserNotFound;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

public final class GetUser {
  public static User getUser(Long id, UserRepository userRepository) throws UserNotFound {
    return userRepository.findById(id).orElseThrow(UserNotFound::new);
  }
}
