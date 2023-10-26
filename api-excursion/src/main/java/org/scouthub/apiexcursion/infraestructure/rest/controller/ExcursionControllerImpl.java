package org.scouthub.apiexcursion.infraestructure.rest.controller;

import java.util.List;
import org.scouthub.apiexcursion.infraestructure.kafka.service.ExcursionService;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcursionControllerImpl implements ExcursionController {

  @Autowired ExcursionService excursionService;

  @Override
  @GetMapping(value = "/excursion")
  public ResponseEntity<Object> getAllExcursions() {
    List<ExcursionDTO> excursions = excursionService.getExcursions();
    return ResponseEntity.status(HttpStatus.OK).body(excursions);
  }
}
