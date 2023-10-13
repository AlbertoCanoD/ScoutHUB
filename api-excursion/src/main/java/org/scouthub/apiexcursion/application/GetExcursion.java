package org.scouthub.apiexcursion.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiexcursion.domain.exception.ExcursionNotFound;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetExcursion {
  public static Excursion get(Long id, ExcursionRepository excursionRepository)
      throws ExcursionNotFound {
    return excursionRepository.findById(id).orElseThrow(ExcursionNotFound::new);
  }
}
