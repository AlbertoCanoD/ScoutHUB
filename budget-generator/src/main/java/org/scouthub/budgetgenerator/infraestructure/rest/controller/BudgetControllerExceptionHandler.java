package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.scouthub.budgetgenerator.domain.exception.ActivityNotFound;
import org.scouthub.budgetgenerator.domain.exception.BudgetNotFound;
import org.scouthub.budgetgenerator.domain.exception.MaterialNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BudgetControllerExceptionHandler {
  @ExceptionHandler(value = {ActivityNotFound.class})
  public ResponseEntity<?> handleActivityDoesNotExist(ActivityNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This activity does not exist");
  }

  @ExceptionHandler(value = {MaterialNotFound.class})
  public ResponseEntity<?> handleMaterialDoesNotExist(MaterialNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This material does not exist");
  }

  @ExceptionHandler(value = {BudgetNotFound.class})
  public ResponseEntity<?> handleBudgetDoesNotExist(BudgetNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This budget does not exist");
  }
}
