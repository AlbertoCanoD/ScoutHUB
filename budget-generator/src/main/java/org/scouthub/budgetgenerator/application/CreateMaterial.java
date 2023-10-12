package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

public final class CreateMaterial {
  private CreateMaterial() {}

  public static void create(Material material, MaterialRepository materialRepository) {
    materialRepository.save(material);
  }
}
