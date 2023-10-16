package org.scouthub.budgetgenerator.domain.exception;

public class BudgetNotFound extends Exception {
  public static final String THE_BUDGET_WITH_ID_D_DOES_NOT_EXISTS =
      "The budget with id %d does not exists";

  public BudgetNotFound(Long id) {
    super(String.format(THE_BUDGET_WITH_ID_D_DOES_NOT_EXISTS, id));
  }
}
