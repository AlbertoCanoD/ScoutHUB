package org.scouthub.budgetgenerator.domain.exception;

public class ActivityDoesNotExists extends Exception {

  public static final String THE_MATERIAL_WITH_ID_D_DOES_NOT_EXISTS =
      "The material with id %d does not exists";

  public ActivityDoesNotExists(Long id) {
    super(String.format(THE_MATERIAL_WITH_ID_D_DOES_NOT_EXISTS, id));
  }
}
