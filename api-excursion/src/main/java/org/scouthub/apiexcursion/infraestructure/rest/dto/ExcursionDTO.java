package org.scouthub.apiexcursion.infraestructure.rest.dto;

import java.util.List;
import java.util.UUID;
import lombok.*;

@Data
@Builder
public class ExcursionDTO {
  UUID excursionId;
  float totalPrice;
  List<BudgetDTO> budgets;
}
