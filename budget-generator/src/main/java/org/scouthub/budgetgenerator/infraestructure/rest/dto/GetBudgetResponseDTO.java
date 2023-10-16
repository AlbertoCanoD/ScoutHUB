package org.scouthub.budgetgenerator.infraestructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetBudgetResponseDTO {
  Long activityId;
  String activityName;
  String activityDescription;
  Long materialId;
  String materialName;
  int materialQuantity;
  float materialPrice;
  float totalCost;
}
