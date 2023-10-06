package org.scouthub.usersender.domain.service;

import org.scouthub.usersender.domain.model.User;

public interface UserService {
  void createUser(User user);

  void deleteUser(Long id);
}
