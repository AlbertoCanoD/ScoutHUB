package org.scouthub.budgetgenerator.application;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAllActivities {
  public static List<Activity> get(ActivityRepository activityRepository) {
    return activityRepository.findAll();
  }
}
