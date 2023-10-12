package org.scouthub.apiuser.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiuser.domain.repository.UserRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteUser {
  public static void delete(Long id, UserRepository userRepository) {
    userRepository.findById(id).ifPresent(userRepository::delete);
  }
}
