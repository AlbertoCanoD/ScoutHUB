package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

public class DeleteMaterial {
  private DeleteMaterial() {}

  public static void delete(
      Long id, MaterialRepository materialRepository, ActivityRepository activityRepository) {
    if (materialRepository.existsById(id)) {
      materialRepository.deleteById(id);
    }
  }
}
