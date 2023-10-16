package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateMaterial {

  public static void create(Material material, MaterialRepository materialRepository) {
    if (material == null) {
      log.error("Material can't be null");
      return;
    }

    log.debug("Creating material {} with id {}", material.getName(), material.getId());
    materialRepository.save(material);
  }
}
