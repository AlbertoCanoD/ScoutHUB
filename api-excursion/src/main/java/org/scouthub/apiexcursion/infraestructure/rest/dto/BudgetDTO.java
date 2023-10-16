package org.scouthub.apiexcursion.infraestructure.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BudgetDTO {
  Long activityId;
  String activityName;
  String activityDescription;
  Long materialId;
  String materialName;
  int materialQuantity;
  float materialPrice;
  float totalCost;
}
