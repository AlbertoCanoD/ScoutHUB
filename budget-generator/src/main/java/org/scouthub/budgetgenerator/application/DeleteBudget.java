package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;

public final class DeleteBudget {
  private DeleteBudget() {}

  public static void delete(
      Long activityId, BudgetRepository budgetRepository, BudgetService budgetService) {
    if (budgetRepository.existsById(activityId)) {
      budgetRepository.deleteById(activityId);
      budgetService.delete(activityId);
    }
  }
}
