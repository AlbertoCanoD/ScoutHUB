package org.scouthub.apiexcursion.application;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DeleteExcursion {
  public static void delete(Long id, ExcursionRepository excursionRepository) {
    excursionRepository.findById(id).ifPresent(excursionRepository::delete);
  }
}
