package org.scouthub.materialsender.infraestructure.rest.controller;

import javax.validation.Valid;
import org.scouthub.materialsender.infraestructure.rest.dto.MaterialRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
public interface MaterialController {

  @PostMapping(value = "/material")
  @ResponseStatus(HttpStatus.ACCEPTED)
  void createMaterial(@Valid @RequestBody MaterialRequestDTO materialRequestDTO);

  @DeleteMapping(value = "/material/{materialId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  void deleteMaterial(@PathVariable Long id);
}
