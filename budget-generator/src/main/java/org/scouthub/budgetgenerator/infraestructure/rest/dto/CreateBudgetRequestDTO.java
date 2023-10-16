package org.scouthub.budgetgenerator.infraestructure.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateBudgetRequestDTO {
  Long activityId;
  Long materialId;
  int materialQuantity;
}
