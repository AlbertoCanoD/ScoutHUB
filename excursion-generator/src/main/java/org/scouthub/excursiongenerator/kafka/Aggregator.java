package org.scouthub.excursiongenerator.kafka;

import org.scouthub.budgetgenerator.infraestructure.kafka.avro.Budget;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetValue;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.stereotype.Component;

@Component
public class Aggregator
    implements org.apache.kafka.streams.kstream.Aggregator<
        ExcursionKey, BudgetValue, ExcursionValue> {
  @Override
  public ExcursionValue apply(
      ExcursionKey excursionKey, BudgetValue budgetValue, ExcursionValue excursionValue) {

    Budget newBudget = createBudget(budgetValue);
    excursionValue.getBudgets().add(newBudget);

    // TODO - No funciona bien
    // Check if there are enough activities
    if (excursionValue.getBudgets().size() >= 2) {
      // Compute the totalPrice by adding the totalCost of the activities
      float totalPrice = 0.0f;

      for (Budget budget : excursionValue.getBudgets()) {
        totalPrice += budget.getTotalCost();
      }

      // Create a new ExcursionValue with the new budget
      return ExcursionValue.newBuilder()
          .setExcursionId(excursionKey.getExcursionId())
          .setBudgets(excursionValue.getBudgets())
          .setTotalPrice(totalPrice)
          .build();
    } else {
      // If there are not enough activities, return null
      return excursionValue;
    }
  }

  private Budget createBudget(BudgetValue budgetValue) {
    return Budget.newBuilder()
        .setActivityId(budgetValue.getActivityId())
        .setActivityName(budgetValue.getActivityName())
        .setActivityDescription(budgetValue.getActivityDescription())
        .setMaterialId(budgetValue.getMaterialId())
        .setMaterialName(budgetValue.getMaterialName())
        .setMaterialQuantity(budgetValue.getMaterialQuantity())
        .setMaterialPrice(budgetValue.getMaterialPrice())
        .setTotalCost(budgetValue.getTotalCost())
        .build();
  }
}
