package org.scouthub.budgetgenerator.domain.exception;

public class MaterialDoesNotExists extends Exception {
  public MaterialDoesNotExists(Long id) {
    super("The material with id " + id + " does not exists");
  }
}
