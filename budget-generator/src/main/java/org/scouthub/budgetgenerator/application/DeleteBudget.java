package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DeleteBudget {
  public static void delete(
      Long activityId, BudgetRepository budgetRepository, BudgetService budgetService) {
    if (budgetRepository.existsById(activityId)) {
      budgetRepository.deleteById(activityId);
      budgetService.delete(activityId);
    }
  }
}
