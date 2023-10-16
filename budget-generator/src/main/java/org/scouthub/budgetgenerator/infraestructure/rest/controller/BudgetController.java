package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface BudgetController {
  @PostMapping("/budget/activity/{activityId}/material/{materialId}/{materialQuantity}")
  @ResponseStatus(HttpStatus.CREATED)
  void createBudget(
      @RequestParam Long activityId,
      @PathVariable Long materialId,
      @PathVariable int materialQuantity);

  @DeleteMapping("/budget/{budgetId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteBudget(@PathVariable Long budgetId);
}
