package org.scouthub.budgetgenerator.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.budgetgenerator.domain.exception.BudgetNotFound;
import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetBudget {
  public static Budget get(Long id, BudgetRepository budgetRepository) throws BudgetNotFound {
    return budgetRepository.findById(id).orElseThrow(BudgetNotFound::new);
  }
}
