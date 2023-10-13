package org.scouthub.apiexcursion.domain.repository;

import org.scouthub.apiexcursion.domain.model.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {}
