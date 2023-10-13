package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.scouthub.budgetgenerator.application.CreateBudget;
import org.scouthub.budgetgenerator.application.DeleteBudget;
import org.scouthub.budgetgenerator.domain.model.BudgetPrimaryKey;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.infraestructure.kafka.service.BudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BudgetControllerImpl implements BudgetController {

  @Autowired ActivityRepository activityRepository;

  @Autowired MaterialRepository materialRepository;

  @Autowired BudgetRepository budgetRepository;

  @Autowired BudgetServiceImpl budgetService;

  @Override
  @PostMapping("/budget/activity/{activityId}/material/{materialId}/{materialQuantity}")
  @ResponseStatus(HttpStatus.CREATED)
  public void createBudget(
      @RequestParam Long activityId,
      @PathVariable Long materialId,
      @PathVariable int materialQuantity) {

    BudgetPrimaryKey budgetPrimaryKey = new BudgetPrimaryKey(activityId, materialId);
    CreateBudget.create(
        budgetPrimaryKey, budgetRepository, activityRepository, materialRepository, budgetService);
  }

  @Override
  @DeleteMapping("/budget/activity/{activityId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBudget(@PathVariable Long activityId, @PathVariable Long materialId) {
    BudgetPrimaryKey budgetPrimaryKey = new BudgetPrimaryKey(activityId, materialId);
    DeleteBudget.delete(
        budgetPrimaryKey, budgetRepository, activityRepository, materialRepository, budgetService);
  }
}
