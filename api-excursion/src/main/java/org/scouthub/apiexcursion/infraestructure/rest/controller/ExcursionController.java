package org.scouthub.apiexcursion.infraestructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface ExcursionController {
  @GetMapping(value = "/excursion")
  ResponseEntity<Object> getAllExcursions();
}
