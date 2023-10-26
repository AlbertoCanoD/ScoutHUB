package org.scouthub.apiexcursion.infraestructure.kafka.service;

import java.util.List;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;

public interface ExcursionService {
  List<ExcursionDTO> getExcursions();

  void create(ExcursionDTO excursionDTO);
}
