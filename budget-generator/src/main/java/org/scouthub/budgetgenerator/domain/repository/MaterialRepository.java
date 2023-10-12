package org.scouthub.budgetgenerator.domain.repository;

import org.scouthub.budgetgenerator.domain.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {}
