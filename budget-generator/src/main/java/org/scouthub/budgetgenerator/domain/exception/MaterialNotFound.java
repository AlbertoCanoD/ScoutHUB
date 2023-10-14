package org.scouthub.budgetgenerator.domain.exception;

public class MaterialNotFound extends Exception {
  public static final String THE_MATERIAL_WITH_ID_D_DOES_NOT_EXISTS =
      "The material with id %d does not exists";

  public MaterialNotFound(Long id) {
    super(String.format(THE_MATERIAL_WITH_ID_D_DOES_NOT_EXISTS, id));
  }
}
