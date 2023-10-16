package org.scouthub.apiexcursion.infraestructure.rest.controller;

import org.scouthub.apiexcursion.domain.exception.ExcursionNotFound;
import org.springframework.http.ResponseEntity;

public interface ExcursionController {
  ResponseEntity<Object> getAllExcursions();

  ResponseEntity<Object> getExcursionById(Long id) throws ExcursionNotFound;
}
