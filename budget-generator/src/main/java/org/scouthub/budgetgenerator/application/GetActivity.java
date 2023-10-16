package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.exception.ActivityNotFound;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetActivity {
  public static Activity get(Long id, ActivityRepository activityRepository)
      throws ActivityNotFound {
    return activityRepository.findById(id).orElseThrow(ActivityNotFound::new);
  }
}
