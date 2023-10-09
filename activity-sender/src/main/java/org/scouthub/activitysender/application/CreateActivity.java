package org.scouthub.activitysender.application;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.activitysender.domain.model.Activity;
import org.scouthub.activitysender.domain.service.ActivityService;

@Slf4j
public class CreateActivity {
  private CreateActivity() {}

  public static void create(Activity activity, ActivityService activityService) {
    if (activity == null) {
      log.error("Activity is null");
      return;
    }

    log.debug("Sending activity to kafka topic");
    activityService.createActivity(activity);
  }
}
