package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;

public final class DeleteActivity {
  private DeleteActivity() {}

  public static void delete(
      Long activityId, ActivityRepository activityRepository, BudgetService budgetService) {
    if (activityRepository.existsById(activityId)) {
      activityRepository.deleteById(activityId);
      budgetService.delete(activityId);
    }
  }
}
