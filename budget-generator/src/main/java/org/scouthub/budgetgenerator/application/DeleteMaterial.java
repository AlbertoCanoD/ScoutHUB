package org.scouthub.budgetgenerator.application;

import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

public final class DeleteMaterial {
  private DeleteMaterial() {}

  public static void delete(Long materialId, MaterialRepository materialRepository) {
    if (materialRepository.existsById(materialId)) {
      materialRepository.deleteById(materialId);
    }
  }
}
