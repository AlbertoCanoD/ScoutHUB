package org.scouthub.budgetgenerator.infraestructure.kafka.service;

import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.service.BudgetService;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {
  static final String BUDGET_TOPIC = "budget";
  @Autowired private KafkaTemplate<BudgetKey, BudgetValue> kafkaTemplate;

  @Override
  public void create(Activity activity, Material material, int materialQuantity, float totalCost) {
    BudgetKey budgetKey = new BudgetKey(activity.getId());

    BudgetValue budgetValue =
        new BudgetValue(
            activity.getId(),
            activity.getName(),
            activity.getDescription(),
            material.getId(),
            material.getName(),
            materialQuantity,
            material.getPrice(),
            totalCost);

    kafkaTemplate.send(BUDGET_TOPIC, budgetKey, budgetValue);
  }

  @Override
  public void delete(Long id) {
    BudgetKey budgetKey = new BudgetKey(id);
    kafkaTemplate.send(BUDGET_TOPIC, budgetKey, null);
  }
}
