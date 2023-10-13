package org.scouthub.apiexcursion.infraestructure.rest.controller;

import org.scouthub.apiexcursion.domain.exception.ExcursionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcursionControllerExceptionHandler {
  @ExceptionHandler(value = {ExcursionNotFound.class})
  public ResponseEntity<?> handleUserNotFound(ExcursionNotFound ex) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
