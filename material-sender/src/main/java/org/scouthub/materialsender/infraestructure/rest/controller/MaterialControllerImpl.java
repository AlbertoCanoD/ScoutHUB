package org.scouthub.materialsender.infraestructure.rest.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.materialsender.application.CreateMaterial;
import org.scouthub.materialsender.application.DeleteMaterial;
import org.scouthub.materialsender.domain.model.Material;
import org.scouthub.materialsender.infraestructure.kafka.service.MaterialServiceImpl;
import org.scouthub.materialsender.infraestructure.rest.dto.MaterialRequestDTO;
import org.scouthub.materialsender.infraestructure.rest.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@Slf4j
public class MaterialControllerImpl implements MaterialController {
  @Autowired MaterialMapper materialMapper;

  @Autowired MaterialServiceImpl materialService;

  @Override
  @PostMapping(value = "/material")
  @ResponseStatus(HttpStatus.CREATED)
  public void createMaterial(@Valid @RequestBody MaterialRequestDTO materialRequestDTO) {
    log.debug("Received request to create material");
    Material material = materialMapper.materialRequestDTOToMaterial(materialRequestDTO);
    CreateMaterial.create(material, materialService);
  }

  @Override
  @DeleteMapping(value = "/material/{materialId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteMaterial(@PathVariable Long materialId) {
    log.debug("Received request to delete material");
    DeleteMaterial.delete(materialId, materialService);
  }
}
