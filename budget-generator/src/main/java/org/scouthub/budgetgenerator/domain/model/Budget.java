package org.scouthub.budgetgenerator.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
  Long materialId;
  int materialQuantity;
  float materialPrice;
  float totalCost;
}
