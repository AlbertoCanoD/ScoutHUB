package org.scouthub.excursiongenerator.kafka;

import java.util.ArrayList;
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

    // Check if there are enough activities
    if (excursionValue.getBudgets().size() >= 2) {
      // Compute the totalPrice by adding the totalCost of the activities
      float totalPrice =
          excursionValue.getBudgets().stream().map(Budget::getTotalCost).reduce(0.0f, Float::sum);

      // Create a new ExcursionValue with the new budget
      return ExcursionValue.newBuilder()
          .setBudgets(new ArrayList<>())
          .setTotalPrice(totalPrice)
          .build();
    } else {
      // If there are not enough activities, return the same ExcursionValue
      return excursionValue;
    }
    //    excursionValue = ExcursionValue.newBuilder()
    //        .setBudgets(excursionValue.getBudgets().stream()
    //            .filter(c -> !budgetValue.getActivityId().equals(c.getActivityId()))
    //            .collect(Collectors.toList())).build();
    //
    //    excursionValue.getBudgets().add(createBudget(budgetValue));
    //
    //    return excursionValue;

    //        ExcursionValue.newBuilder().setBudgets(excursionValue.getBudgets()).stream()
    //            .filter(c ->
    // !budgetValue.getActivityId().equals(c.getActivityId())).collect(Collectors.toList())).build();

    //    float totalPrice =
    //        (excursionValue != null ? excursionValue.getTotalPrice() : 0) +
    // budgetValue.getTotalCost();
    //    return ExcursionValue.newBuilder().setTotalPrice(totalPrice).build();
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
