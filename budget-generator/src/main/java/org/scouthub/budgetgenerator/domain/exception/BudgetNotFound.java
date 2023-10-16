package org.scouthub.budgetgenerator.domain.exception;

public class BudgetNotFound extends Exception {
  public static final String THE_BUDGET_DOES_NOT_EXISTS = "The budget does not exists";

  public BudgetNotFound() {
    super(THE_BUDGET_DOES_NOT_EXISTS);
  }
}
