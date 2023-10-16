package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetMaterial {
  public static Material get(Long id, MaterialRepository materialRepository) {
    return materialRepository.findById(id).orElse(null);
  }
}
