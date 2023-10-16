package org.scouthub.apiexcursion.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;

@Mapper(componentModel = "spring")
public interface ExcursionMapper {
  ExcursionDTO excursionToExcursionDTO(Excursion excursion);

  List<ExcursionDTO> excursionListToExcursionDTOList(List<Excursion> excursions);
}
