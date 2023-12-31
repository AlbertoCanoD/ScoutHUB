package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DeleteMaterial {
  public static void delete(Long materialId, MaterialRepository materialRepository) {
    if (materialRepository.existsById(materialId)) materialRepository.deleteById(materialId);
  }
}
