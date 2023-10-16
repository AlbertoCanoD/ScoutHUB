package org.scouthub.apiexcursion.infraestructure.kafka.service;

import java.util.List;
import java.util.UUID;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;

public interface ExcursionService {
  List<ExcursionDTO> getExcursions();

  ExcursionDTO getExcursionById(UUID excursionId);

  void create(ExcursionDTO excursionDTO);
}
