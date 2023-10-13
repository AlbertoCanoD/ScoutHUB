package org.scouthub.budgetgenerator.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  Long activityId;
  String activityName;
  String activityDescription;
  Long materialId;
  int materialQuantity;
  float materialPrice;
  float totalCost;
}
