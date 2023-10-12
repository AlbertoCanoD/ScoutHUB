package org.scouthub.budgetgenerator.application;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.service.ActivityService;

@Slf4j
public class CreateActivity {
  private CreateActivity() {}

  public static void create(
      Activity activity, ActivityRepository activityRepository, ActivityService activityService) {
    if (activity == null) {
      log.error("Activity can't be null");
      return;
    }

    log.debug("Creating activity {} with id {}", activity.getName(), activity.getId());
    activityRepository.save(activity);
    activityService.createActivity(activity);
  }
}
