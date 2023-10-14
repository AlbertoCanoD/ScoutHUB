package org.scouthub.budgetgenerator.domain.service;

import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.model.Material;

public interface BudgetService {
  void create(Activity activity, Material material, int materialQuantity, float totalCost);

  void delete(Long id);
}
