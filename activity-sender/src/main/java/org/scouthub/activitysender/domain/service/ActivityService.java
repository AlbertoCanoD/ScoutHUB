package org.scouthub.activitysender.domain.service;

import org.scouthub.activitysender.domain.model.Activity;

public interface ActivityService {
  void createActivity(Activity activity);

  void deleteActivity(Long id);
}
