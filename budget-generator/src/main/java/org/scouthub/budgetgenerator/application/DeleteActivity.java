package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;

public final class DeleteActivity {
  private DeleteActivity() {}

  public static void delete(Long activityId, ActivityRepository activityRepository) {
    if (activityRepository.existsById(activityId)) activityRepository.deleteById(activityId);
  }
}
