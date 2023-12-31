package org.scouthub.budgetgenerator.domain.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
  @Id Long activityId;
  String activityName;
  String activityDescription;
  Long materialId;
  String materialName;
  int materialQuantity;
  float materialPrice;
  float totalCost;
}
