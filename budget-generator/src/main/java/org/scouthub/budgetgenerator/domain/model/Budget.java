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
  @EmbeddedId BudgetPrimaryKey id;
  @OneToOne()
  @JoinColumn(name = "budget_activity")
  @MapsId("activity")
  Activity activity;
  @OneToOne()
  @JoinColumn(name = "budget_material")
  @MapsId("material")
  Material material;

  Budget(BudgetPrimaryKey id) {}

  //  Long activityId;
  //  String activityName;
  //  String activityDescription;
  //  Long materialId;
  //  int materialQuantity;
  //  float materialPrice;
  //  float totalCost;
}
