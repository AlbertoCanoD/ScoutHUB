package org.scouthub.apiuser.infraestructure.rest.controller;

import org.scouthub.apiuser.domain.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerExceptionHandler {
  @ExceptionHandler(value = {UserNotFound.class})
  public ResponseEntity<?> handleUserNotFound(UserNotFound ex) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
