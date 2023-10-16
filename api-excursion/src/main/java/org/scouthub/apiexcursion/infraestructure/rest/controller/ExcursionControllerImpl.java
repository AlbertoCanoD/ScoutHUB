package org.scouthub.apiexcursion.infraestructure.rest.controller;

import java.util.List;
import java.util.UUID;
import org.scouthub.apiexcursion.infraestructure.kafka.service.ExcursionService;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;
import org.scouthub.apiexcursion.infraestructure.rest.mapper.ExcursionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcursionControllerImpl implements ExcursionController {

  @Autowired ExcursionService excursionService;

  // TODO - Revisar si devolver Object o excursiones

  @Override
  @GetMapping(value = "/excursion")
  public ResponseEntity<Object> getAllExcursions() {
    //    List<Excursion> excursions = GetAllExcursions.get(excursionRepository);
    //    List<ExcursionDTO> excursionDTO = excursionMapper.entityListToDtoList(excursions);
    //    return ResponseEntity.status(HttpStatus.OK).body(excursionDTO);
    List<ExcursionDTO> excursions = excursionService.getExcursions();
    return ResponseEntity.status(HttpStatus.OK).body(excursions);
  }

  @Override
  @GetMapping(value = "/excursion/{id}")
  public ResponseEntity<Object> getExcursionById(@PathVariable UUID id) {
    //    Excursion excursion = GetExcursion.get(id, excursionRepository);
    //    ExcursionDTO excursionDTO = excursionMapper.entityToDto(excursion);
    //    return ResponseEntity.status(HttpStatus.OK).body(excursionDTO);
    ExcursionDTO excursionDTO = excursionService.getExcursionById(id);
    return ResponseEntity.status(HttpStatus.OK).body(excursionDTO);
  }
}
