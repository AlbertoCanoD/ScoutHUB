package org.scouthub.budgetgenerator.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetBudgetResponseDTO;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
  GetBudgetResponseDTO budgetToGetBudgetResponseDTO(Budget budget);

  List<GetBudgetResponseDTO> budgetListToGetBudgetResponseDTOList(List<Budget> budgets);
}
