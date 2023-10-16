package org.scouthub.budgetgenerator.domain.exception;

public class MaterialNotFound extends Exception {
  public static final String THIS_MATERIAL_DOES_NOT_EXISTS = "This material does not exists";

  public MaterialNotFound() {
    super(THIS_MATERIAL_DOES_NOT_EXISTS);
  }
}
