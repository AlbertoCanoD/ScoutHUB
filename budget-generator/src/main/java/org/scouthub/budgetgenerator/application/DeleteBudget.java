package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.model.BudgetPrimaryKey;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.infraestructure.kafka.service.BudgetServiceImpl;

public final class DeleteBudget {
  private DeleteBudget() {}

  public static void delete() {
    // TODO - Implementar
  }

  public static void delete(BudgetPrimaryKey budgetPrimaryKey, BudgetRepository budgetRepository, ActivityRepository activityRepository, MaterialRepository materialRepository, BudgetServiceImpl budgetService) {
  }
}
