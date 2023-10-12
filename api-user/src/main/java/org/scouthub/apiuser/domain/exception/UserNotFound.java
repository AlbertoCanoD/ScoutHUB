package org.scouthub.apiuser.domain.exception;

public class UserNotFound extends Exception {

  public static final String USER_DOES_NOT_EXIST = "The user does not exist.";

  public UserNotFound() {
    super(USER_DOES_NOT_EXIST);
  }
}
