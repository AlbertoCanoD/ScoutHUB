package org.scouthub.uservalidator.domain.service;

import org.scouthub.uservalidator.domain.model.User;

public interface UserService {
  void createUser(User user);

  void deleteUser(Long id);
}
