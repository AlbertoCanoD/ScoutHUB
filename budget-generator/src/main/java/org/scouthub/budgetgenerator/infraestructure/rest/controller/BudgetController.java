package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import javax.validation.Valid;
import org.scouthub.budgetgenerator.domain.exception.ActivityNotFound;
import org.scouthub.budgetgenerator.domain.exception.BudgetNotFound;
import org.scouthub.budgetgenerator.domain.exception.MaterialNotFound;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.CreateBudgetRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BudgetController {
  @PostMapping("/budget")
  @ResponseStatus(HttpStatus.CREATED)
  void createBudget(@RequestBody @Valid CreateBudgetRequestDTO requestDTO);

  @DeleteMapping("/budget/{budgetId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteBudget(@PathVariable Long budgetId);

  @GetMapping("/budget/{budgetId}")
  ResponseEntity<Object> getBudget(@PathVariable Long budgetId) throws BudgetNotFound;

  @GetMapping(value = "/budget")
  ResponseEntity<Object> getAllBudgets();

  @GetMapping("/activity/{activityId}")
  ResponseEntity<Object> getActivity(@PathVariable Long activityId) throws ActivityNotFound;

  @GetMapping(value = "/activity")
  ResponseEntity<Object> getAllActivities();

  @GetMapping("/material/{materialId}")
  ResponseEntity<Object> getMaterial(@PathVariable Long materialId) throws MaterialNotFound;

  @GetMapping(value = "/activity")
  ResponseEntity<Object> getAllMaterials();
}
