package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DeleteActivity {
  public static void delete(Long activityId, ActivityRepository activityRepository) {
    if (activityRepository.existsById(activityId)) activityRepository.deleteById(activityId);
  }
}
