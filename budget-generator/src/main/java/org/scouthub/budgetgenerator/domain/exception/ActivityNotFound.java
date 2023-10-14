package org.scouthub.budgetgenerator.domain.exception;

public class ActivityNotFound extends Exception {
  public static final String THE_ACTIVITY_WITH_ID_D_DOES_NOT_EXISTS =
      "The activity with id %d does not exists";

  public ActivityNotFound(Long id) {
    super(String.format(THE_ACTIVITY_WITH_ID_D_DOES_NOT_EXISTS, id));
  }
}
