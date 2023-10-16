package org.scouthub.budgetgenerator.domain.exception;

public class ActivityNotFound extends Exception {
  public static final String THE_ACTIVITY_DOES_NOT_EXISTS = "The activity does not exists";

  public ActivityNotFound() {
    super(THE_ACTIVITY_DOES_NOT_EXISTS);
  }
}
