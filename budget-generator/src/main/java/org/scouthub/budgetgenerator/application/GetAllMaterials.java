package org.scouthub.budgetgenerator.application;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAllMaterials {
  public static List<Material> get(MaterialRepository materialRepository) {
    return materialRepository.findAll();
  }
}
