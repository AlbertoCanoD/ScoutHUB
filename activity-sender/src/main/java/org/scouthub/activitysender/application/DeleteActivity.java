package org.scouthub.activitysender.application;

import org.scouthub.activitysender.domain.service.ActivityService;

public class DeleteActivity {
  private DeleteActivity() {}

  public static void delete(Long id, ActivityService activityService) {
    activityService.deleteActivity(id);
  }
}
