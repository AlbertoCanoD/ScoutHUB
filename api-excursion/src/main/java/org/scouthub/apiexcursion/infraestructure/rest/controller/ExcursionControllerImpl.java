package org.scouthub.apiexcursion.infraestructure.rest.controller;

import java.util.List;
import java.util.UUID;

import org.scouthub.apiexcursion.application.GetAllExcursions;
import org.scouthub.apiexcursion.application.GetExcursion;
import org.scouthub.apiexcursion.domain.exception.ExcursionNotFound;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;
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

  @Autowired ExcursionRepository excursionRepository;

  @Autowired ExcursionMapper excursionMapper;

  // TODO - Revisar si devolver Object o excursiones

  @Override
  @GetMapping(value = "/excursion")
  public ResponseEntity<Object> getAllExcursions() {
    List<Excursion> excursions = GetAllExcursions.get(excursionRepository);
    List<ExcursionDTO> excursionDTO =
        excursionMapper.excursionListToExcursionDTOList(excursions);
    return ResponseEntity.status(HttpStatus.OK).body(excursionDTO);
  }

  @Override
  @GetMapping(value = "/excursion/{id}")
  public ResponseEntity<Object> getExcursionById(@PathVariable UUID id) throws ExcursionNotFound {
    Excursion excursion = GetExcursion.get(id, excursionRepository);
    ExcursionDTO excursionDTO =
        excursionMapper.excursionToExcursionDTO(excursion);
    return ResponseEntity.status(HttpStatus.OK).body(excursionDTO);
  }
}
