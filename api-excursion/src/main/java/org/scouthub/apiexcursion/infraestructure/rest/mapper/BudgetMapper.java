package org.scouthub.apiexcursion.infraestructure.rest.mapper;

import org.scouthub.apiexcursion.domain.model.Budget;
import org.scouthub.apiexcursion.infraestructure.rest.dto.BudgetDTO;

public class BudgetMapper extends GenericMapper<Budget, BudgetDTO> {
  @Override
  public BudgetDTO entityToDto(Budget budget) {
    return BudgetDTO.builder()
        .activityId(budget.getActivityId())
        .activityName(budget.getActivityName())
        .activityDescription(budget.getActivityDescription())
        .materialId(budget.getMaterialId())
        .materialName(budget.getMaterialName())
        .materialQuantity(budget.getMaterialQuantity())
        .materialPrice(budget.getMaterialPrice())
        .totalCost(budget.getTotalCost())
        .build();
  }

  @Override
  public Budget dtoToEntity(BudgetDTO dto) {
    Budget budget = new Budget();
    budget.setActivityId(dto.getActivityId());
    budget.setActivityName(dto.getActivityName());
    budget.setActivityDescription(dto.getActivityDescription());
    budget.setMaterialId(dto.getMaterialId());
    budget.setMaterialName(dto.getMaterialName());
    budget.setMaterialQuantity(dto.getMaterialQuantity());
    budget.setMaterialPrice(dto.getMaterialPrice());
    budget.setTotalCost(dto.getTotalCost());
    return budget;
  }
}
