package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.model.BudgetPrimaryKey;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;

public final class CreateBudget {
  private CreateBudget() {}

  public static void create(
      BudgetPrimaryKey budgetKey,
      BudgetRepository budgetRepository,
      ActivityRepository activityRepository,
      MaterialRepository materialRepository,
      BudgetService budgetService) {
    // TODO - Implementar
  }
}
