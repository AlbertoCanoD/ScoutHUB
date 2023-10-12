package org.scouthub.budgetgenerator.domain.repository;

import org.scouthub.budgetgenerator.domain.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
  void deleteByMaterialId(Long id);
}
