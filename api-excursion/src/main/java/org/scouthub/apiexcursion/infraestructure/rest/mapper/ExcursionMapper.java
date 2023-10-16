package org.scouthub.apiexcursion.infraestructure.rest.mapper;

import java.util.List;
import org.scouthub.apiexcursion.domain.model.Budget;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.infraestructure.rest.dto.BudgetDTO;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;

public class ExcursionMapper extends GenericMapper<Excursion, ExcursionDTO> {
  @Override
  public ExcursionDTO entityToDto(Excursion excursion) {

    List<BudgetDTO> budgets = new BudgetMapper().entityListToDtoList(excursion.getBudgets());

    return ExcursionDTO.builder()
        .excursionId(excursion.getExcursionId())
        .totalPrice(excursion.getTotalPrice())
        .budgets(budgets)
        .build();
  }

  @Override
  public Excursion dtoToEntity(ExcursionDTO excursionDTO) {

    List<Budget> budgets = new BudgetMapper().dtoListToEntityList(excursionDTO.getBudgets());

    Excursion excursion = new Excursion();
    excursion.setExcursionId(excursionDTO.getExcursionId());
    excursion.setTotalPrice(excursionDTO.getTotalPrice());
    excursion.setBudgets(budgets);
    return excursion;
  }
}
