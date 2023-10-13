package org.scouthub.apiexcursion.domain.exception;

public class ExcursionNotFound extends Exception {

  public static final String EXCURSION_DOES_NOT_EXIST = "The excursion does not exist.";

  public ExcursionNotFound() {
    super(EXCURSION_DOES_NOT_EXIST);
  }
}
