package org.scouthub.materialsender.application;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.materialsender.domain.model.Material;
import org.scouthub.materialsender.domain.service.MaterialService;

@Slf4j
public class CreateMaterial {
  private CreateMaterial() {}

  public static void create(Material material, MaterialService materialService) {
    if (material == null) {
      log.error("Material is null");
      return;
    }

    log.debug("Sending material {} to kafka topic", material.getId());
    materialService.createMaterial(material);
  }
}
