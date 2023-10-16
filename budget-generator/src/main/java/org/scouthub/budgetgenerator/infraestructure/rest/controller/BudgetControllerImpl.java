package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.scouthub.budgetgenerator.application.*;
import org.scouthub.budgetgenerator.domain.exception.ActivityNotFound;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.infraestructure.kafka.service.BudgetServiceImpl;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetActivityResponseDTO;
import org.scouthub.budgetgenerator.infraestructure.rest.mapper.ActivityMapper;
import org.scouthub.budgetgenerator.infraestructure.rest.mapper.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BudgetControllerImpl implements BudgetController {

  @Autowired ActivityRepository activityRepository;

  @Autowired MaterialRepository materialRepository;

  @Autowired BudgetRepository budgetRepository;

  @Autowired BudgetServiceImpl budgetService;

  @Autowired ActivityMapper activityMapper;

  @Autowired BudgetMapper budgetMapper;

//  @Autowired MaterialMapper materialMapper;

  @Override
  @PostMapping("/budget/activity/{activityId}/material/{materialId}/{materialQuantity}")
  @ResponseStatus(HttpStatus.CREATED)
  public void createBudget(
      @PathVariable Long activityId,
      @PathVariable Long materialId,
      @PathVariable int materialQuantity) {
    CreateBudget.create(
        activityId,
        materialId,
        materialQuantity,
        activityRepository,
        materialRepository,
        budgetRepository,
        budgetService);
  }

  @Override
  @DeleteMapping("/budget/{budgetId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBudget(@PathVariable Long budgetId) {
    DeleteBudget.delete(budgetId, budgetRepository, budgetService);
  }

  @GetMapping("/budget/{budgetId}")
  public ResponseEntity<Budget> getBudget(@PathVariable Long budgetId) {
    GetBudget.get(budgetId, budgetRepository);
    return null;
  }

  @GetMapping("/activity/{activityId}")
  public ResponseEntity<Object> getActivity(@PathVariable Long activityId) throws ActivityNotFound {
    Activity activity = GetActivity.get(activityId, activityRepository);
    GetActivityResponseDTO getActivityResponseDTO =
        activityMapper.activityToGetActivityResponseDTO(activity);
    return ResponseEntity.status(HttpStatus.OK).body(getActivityResponseDTO);
  }

//  @GetMapping("/material/{materialId}")
//  public ResponseEntity<Object> getMaterial(@PathVariable Long materialId) {
//    Material material = GetMaterial.get(materialId, materialRepository);
//    GetMaterialResponseDTO getMaterialResponseDTO =
//        materialMapper.materialToGetMaterialResponseDTO(material);
//    return ResponseEntity.status(HttpStatus.OK).body(getMaterialResponseDTO);
//  }
}
