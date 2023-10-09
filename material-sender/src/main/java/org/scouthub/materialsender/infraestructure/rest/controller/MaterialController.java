package org.scouthub.materialsender.infraestructure.rest.controller;

import org.scouthub.materialsender.infraestructure.rest.dto.MaterialDeleteRequestDTO;
import org.scouthub.materialsender.infraestructure.rest.dto.MaterialRequestDTO;

@SuppressWarnings("unused")
public interface MaterialController {
  void createMaterial(MaterialRequestDTO materialRequestDTO);

  void deleteMaterial(MaterialDeleteRequestDTO materialDeleteRequestDTO);
}
