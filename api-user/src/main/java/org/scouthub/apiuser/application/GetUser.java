package org.scouthub.apiuser.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiuser.domain.exception.UserNotFound;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetUser {
  public static User get(Long id, UserRepository userRepository) throws UserNotFound {
    return userRepository.findById(id).orElseThrow(UserNotFound::new);
  }
}
