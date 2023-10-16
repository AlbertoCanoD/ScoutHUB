package org.scouthub.budgetgenerator.domain.exception;

public class ActivityNotFound extends Exception {
  public static final String THIS_MATERIAL_DOES_NOT_EXIST = "This material does not exist";

  public ActivityNotFound() {
    super(THIS_MATERIAL_DOES_NOT_EXIST);
  }
}
