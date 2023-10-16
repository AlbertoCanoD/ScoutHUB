package org.scouthub.apiexcursion.domain.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
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
