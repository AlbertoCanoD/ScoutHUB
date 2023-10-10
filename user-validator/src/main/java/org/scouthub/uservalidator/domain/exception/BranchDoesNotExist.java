package org.scouthub.uservalidator.domain.exception;

public class BranchDoesNotExist extends Exception {
  public static final String BRANCH_DOES_NOT_EXIST = "Branch does not exist";

  public BranchDoesNotExist() {
    super(BRANCH_DOES_NOT_EXIST);
  }
}
