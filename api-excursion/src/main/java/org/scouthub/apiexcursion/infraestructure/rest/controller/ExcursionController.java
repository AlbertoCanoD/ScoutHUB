package org.scouthub.apiexcursion.infraestructure.rest.controller;

import org.scouthub.apiexcursion.domain.exception.ExcursionNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface ExcursionController {
  @GetMapping(value = "/excursion")
  ResponseEntity<Object> getAllExcursions();

  @GetMapping(value = "/excursion/{id}")
  ResponseEntity<Object> getExcursionById(@PathVariable UUID id) throws ExcursionNotFound;
}
