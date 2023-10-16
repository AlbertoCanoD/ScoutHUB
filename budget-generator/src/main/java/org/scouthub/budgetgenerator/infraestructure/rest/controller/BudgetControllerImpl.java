package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import java.util.List;
import javax.validation.Valid;
import org.scouthub.budgetgenerator.application.*;
import org.scouthub.budgetgenerator.domain.exception.ActivityNotFound;
import org.scouthub.budgetgenerator.domain.exception.BudgetNotFound;
import org.scouthub.budgetgenerator.domain.exception.MaterialNotFound;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.infraestructure.kafka.service.BudgetServiceImpl;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.CreateBudgetRequestDTO;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetActivityResponseDTO;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetBudgetResponseDTO;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetMaterialResponseDTO;
import org.scouthub.budgetgenerator.infraestructure.rest.mapper.ActivityMapper;
import org.scouthub.budgetgenerator.infraestructure.rest.mapper.BudgetMapper;
import org.scouthub.budgetgenerator.infraestructure.rest.mapper.MaterialMapperI;
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

  @Autowired MaterialMapperI materialMapper;

  @Override
  @PostMapping("/budget")
  @ResponseStatus(HttpStatus.CREATED)
  public void createBudget(@RequestBody @Valid CreateBudgetRequestDTO requestDTO) {
    CreateBudget.create(
        requestDTO.getActivityId(),
        requestDTO.getMaterialId(),
        requestDTO.getMaterialQuantity(),
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

  @Override
  @GetMapping("/budget/{budgetId}")
  public ResponseEntity<Object> getBudget(@PathVariable Long budgetId) throws BudgetNotFound {
    Budget budget = GetBudget.get(budgetId, budgetRepository);
    GetBudgetResponseDTO getBudgetResponseDTO = budgetMapper.budgetToGetBudgetResponseDTO(budget);
    return ResponseEntity.status(HttpStatus.OK).body(getBudgetResponseDTO);
  }

  @Override
  @GetMapping(value = "/budget")
  public ResponseEntity<Object> getAllBudgets() {
    List<Budget> budgets = GetAllBudgets.get(budgetRepository);
    List<GetBudgetResponseDTO> getBudgetResponseDTOList =
        budgetMapper.budgetListToGetBudgetResponseDTOList(budgets);
    return ResponseEntity.status(HttpStatus.OK).body(getBudgetResponseDTOList);
  }

  @Override
  @GetMapping("/activity/{activityId}")
  public ResponseEntity<Object> getActivity(@PathVariable Long activityId) throws ActivityNotFound {
    Activity activity = GetActivity.get(activityId, activityRepository);
    GetActivityResponseDTO getActivityResponseDTO =
        activityMapper.activityToGetActivityResponseDTO(activity);
    return ResponseEntity.status(HttpStatus.OK).body(getActivityResponseDTO);
  }

  @Override
  @GetMapping(value = "/activity")
  public ResponseEntity<Object> getAllActivities() {
    List<Activity> activities = GetAllActivities.get(activityRepository);
    List<GetActivityResponseDTO> getActivityResponseDTOList =
        activityMapper.activityListToGetActivityResponseDTOList(activities);
    return ResponseEntity.status(HttpStatus.OK).body(getActivityResponseDTOList);
  }

  @Override
  @GetMapping("/material/{materialId}")
  public ResponseEntity<Object> getMaterial(@PathVariable Long materialId) throws MaterialNotFound {
    Material material = GetMaterial.get(materialId, materialRepository);
    GetMaterialResponseDTO getMaterialResponseDTO =
        materialMapper.materialToGetMaterialResponseDTO(material);
    return ResponseEntity.status(HttpStatus.OK).body(getMaterialResponseDTO);
  }

  @Override
  @GetMapping(value = "/material")
  public ResponseEntity<Object> getAllMaterials() {
    List<Material> materials = GetAllMaterials.get(materialRepository);
    List<GetMaterialResponseDTO> getMaterialResponseDTOList =
        materialMapper.materialListToGetMaterialResponseDTOList(materials);
    return ResponseEntity.status(HttpStatus.OK).body(getMaterialResponseDTOList);
  }
}
