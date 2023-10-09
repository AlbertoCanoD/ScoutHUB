package org.scouthub.materialsender.domain.service;

import org.scouthub.materialsender.domain.model.Material;

public interface MaterialService {
  void createMaterial(Material material);

  void deleteMaterial(Long id);
}
