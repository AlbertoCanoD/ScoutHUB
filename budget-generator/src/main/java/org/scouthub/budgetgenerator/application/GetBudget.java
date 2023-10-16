package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetBudget {
  public static Budget get(Long id, BudgetRepository budgetRepository) {
    return budgetRepository.findById(id).orElse(null);
  }
}
