package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.service.ActivityService;

public class DeleteActivity {
  private DeleteActivity() {}

  public static void delete(
      Long id, ActivityRepository activityRepository, ActivityService activityService) {
    if (activityRepository.existsById(id)) {
      activityRepository.deleteById(id);
      activityService.deleteActivity(id);
    }
  }
}
