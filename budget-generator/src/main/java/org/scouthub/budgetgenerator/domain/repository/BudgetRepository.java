package org.scouthub.budgetgenerator.domain.repository;

import org.scouthub.budgetgenerator.domain.model.Budget;
import org.scouthub.budgetgenerator.domain.model.BudgetPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, BudgetPrimaryKey> {
  Budget findByActivityId(Long activityId);
}
