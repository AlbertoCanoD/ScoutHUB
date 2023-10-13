package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.scouthub.budgetgenerator.domain.exception.ActivityDoesNotExists;
import org.scouthub.budgetgenerator.domain.exception.MaterialDoesNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BudgetControllerExceptionHandler {
  @ExceptionHandler(value = {ActivityDoesNotExists.class})
  public ResponseEntity<?> handleActivityDoesNotExist(ActivityDoesNotExists ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This activity does not exist");
  }

  @ExceptionHandler(value = {MaterialDoesNotExists.class})
  public ResponseEntity<?> handleMaterialDoesNotExist(MaterialDoesNotExists ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This material does not exist");
  }
}
