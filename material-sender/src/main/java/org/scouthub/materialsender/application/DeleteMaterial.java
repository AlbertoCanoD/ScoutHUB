package org.scouthub.materialsender.application;

import org.scouthub.materialsender.domain.service.MaterialService;

public class DeleteMaterial {
  private DeleteMaterial() {}

  public static void delete(Long id, MaterialService materialService) {
    materialService.deleteMaterial(id);
  }
}
