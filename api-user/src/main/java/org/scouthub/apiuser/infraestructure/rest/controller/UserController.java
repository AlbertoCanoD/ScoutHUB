package org.scouthub.apiuser.infraestructure.rest.controller;

import org.scouthub.apiuser.domain.exception.UserNotFound;
import org.springframework.http.ResponseEntity;

public interface UserController {
  ResponseEntity<Object> getAllUsers();

  ResponseEntity<Object> getUserById(Long id) throws UserNotFound;
}
