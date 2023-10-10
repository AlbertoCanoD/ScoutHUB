package org.scouthub.uservalidator.domain.exception;

public class UserDoesNotExist extends Exception {

  public static final String USER_DOES_NOT_EXIST = "User does not exist";

  public UserDoesNotExist() {
    super(USER_DOES_NOT_EXIST);
  }
}
