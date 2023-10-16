package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateBudget {
  public static void create(
      Long activityId,
      Long materialId,
      int materialQuantity,
      ActivityRepository activityRepository,
      MaterialRepository materialRepository,
      BudgetRepository budgetRepository,
      BudgetService budgetService) {
    Activity activity = activityRepository.findById(activityId).orElse(null);
    Material material = materialRepository.findById(materialId).orElse(null);

    if (activity == null) {
      log.error("Activity with id {} not found", activityId);
      return;
    }

    if (material == null) {
      log.error("Material with id {} not found", materialId);
      return;
    }

    log.debug(
        "Creating budget for activity {} with id {}, and material {} with id {}",
        activity.getName(),
        activity.getId(),
        material.getName(),
        material.getId());

    float materialPrice = material.getPrice();
    float totalCost = materialPrice * materialQuantity;

    Budget budget =
        new Budget(
            activity.getId(),
            activity.getName(),
            activity.getDescription(),
            materialId,
            material.getName(),
            materialQuantity,
            materialPrice,
            totalCost);

    budgetRepository.save(budget);
    budgetService.create(activity, material, materialQuantity, totalCost);
  }
}
