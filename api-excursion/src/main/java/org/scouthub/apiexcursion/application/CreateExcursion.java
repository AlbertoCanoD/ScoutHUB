package org.scouthub.apiexcursion.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateExcursion {
  public static void create(Excursion excursion, ExcursionRepository excursionRepository) {
    excursionRepository.save(excursion);
  }
}
