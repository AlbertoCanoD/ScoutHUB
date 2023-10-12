package org.scouthub.budgetgenerator.infraestructure.kafka.service;

import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.ActivityService;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
  static final String BUDGET_TOPIC = "budget";
  @Autowired private KafkaTemplate<BudgetKey, BudgetValue> kafkaTemplate;

  @Autowired private MaterialRepository materialRepository;

  @Override
  public void createActivity(Activity activity) {
    BudgetKey budgetKey = new BudgetKey(activity.getId());

    float materialPrice = materialRepository.getReferenceById(activity.getMaterialId()).getPrice();
    float totalCost = materialPrice * activity.getMaterialQuantity();

    BudgetValue budgetValue =
        new BudgetValue(
            activity.getId(),
            activity.getName(),
            activity.getMaterialId(),
            activity.getMaterialQuantity(),
            materialPrice,
            totalCost);

    kafkaTemplate.send(BUDGET_TOPIC, budgetKey, budgetValue);
  }

  @Override
  public void deleteActivity(Long id) {
    BudgetKey budgetKey = new BudgetKey(id);
    kafkaTemplate.send(BUDGET_TOPIC, budgetKey, null);
  }
}
