package org.scouthub.budgetgenerator.domain.service;

import org.scouthub.budgetgenerator.domain.model.Activity;

public interface BudgetService {
  void create(Activity activity);

  void delete(Long id);
}
