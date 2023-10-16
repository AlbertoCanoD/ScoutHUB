package org.scouthub.budgetgenerator.application;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAllBudgets {
  public static List<Budget> get(BudgetRepository budgetRepository) {
    return budgetRepository.findAll();
  }
}
