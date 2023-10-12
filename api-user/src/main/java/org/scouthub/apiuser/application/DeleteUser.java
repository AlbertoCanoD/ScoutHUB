package org.scouthub.apiuser.application;

import org.scouthub.apiuser.domain.repository.UserRepository;

public class DeleteUser {
  public static void delete(Long id, UserRepository userRepository) {
    userRepository.findById(id).ifPresent(userRepository::delete);
  }
}
