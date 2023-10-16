package org.scouthub.apiexcursion.infraestructure.kafka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.scouthub.apiexcursion.domain.model.Budget;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;
import org.scouthub.apiexcursion.infraestructure.rest.mapper.BudgetMapper;
import org.scouthub.apiexcursion.infraestructure.rest.mapper.ExcursionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcursionServiceImpl implements ExcursionService {
  @Autowired ExcursionRepository excursionRepository;

  @Override
  public List<ExcursionDTO> getExcursions() {
    List<Excursion> excursions = excursionRepository.findAll();
    return new ExcursionMapper().entityListToDtoList(excursions);
  }

  @Override
  public ExcursionDTO getExcursionById(UUID excursionId) {
    Optional<Excursion> excursion = excursionRepository.findById(excursionId);

    if (excursion.isPresent()) {
      Excursion excursionEntity = excursion.get();
      return new ExcursionMapper().entityToDto(excursionEntity);
    }
    return null;
  }

  @Override
  public void create(ExcursionDTO excursionDTO) {
    Optional<Excursion> existingExcursion =
        excursionRepository.findById(excursionDTO.getExcursionId());

    if (existingExcursion.isPresent()) {
      List<Budget> budgets = new BudgetMapper().dtoListToEntityList(excursionDTO.getBudgets());
      Excursion excursion =
          new Excursion(excursionDTO.getExcursionId(), excursionDTO.getTotalPrice(), budgets);
      excursionRepository.save(excursion);
    }

    Excursion newExcursion = new ExcursionMapper().dtoToEntity(excursionDTO);
    excursionRepository.save(newExcursion);
  }
}
