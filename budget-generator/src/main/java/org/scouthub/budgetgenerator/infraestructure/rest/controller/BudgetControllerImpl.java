package org.scouthub.budgetgenerator.infraestructure.rest.controller;

import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.ActivityService;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budgetgenerator.infraestructure.kafka.service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    ActivityServiceImpl activityService;

    @PostMapping("/activity/{activityId}/material/{materialId}/{materialQuantity}")
    public ResponseEntity<Budget> createBudget(
            @PathVariable Long activityId,
            @PathVariable Long materialId,
            @PathVariable int materialQuantity) {

        BudgetKey budgetKey = new BudgetKey(activityId);
        // Lógica para crear un presupuesto a partir de la actividad, material y cantidad
        Budget budget = budgetService.createBudget(activityId, materialId, materialQuantity);

        return ResponseEntity.status(HttpStatus.CREATED).body(budget);
    }

    @DeleteMapping("/{budgetId}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long budgetId) {

        // Lógica para eliminar un presupuesto por su ID
        budgetService.deleteBudget(budgetId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
