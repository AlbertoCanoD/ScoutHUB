package org.scouthub.apiexcursion.application;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAllExcursions {
  public static List<Excursion> get(ExcursionRepository excursionRepository) {
    return excursionRepository.findAll();
  }
}
