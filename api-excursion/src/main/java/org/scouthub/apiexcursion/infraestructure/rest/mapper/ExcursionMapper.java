package org.scouthub.apiexcursion.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.infraestructure.rest.dto.GetExcursionResponseDTO;

@Mapper(componentModel = "spring")
public interface ExcursionMapper {
  GetExcursionResponseDTO excursionToGetExcursionResponseDTO(Excursion excursion);

  List<GetExcursionResponseDTO> excursionListToGetExcursionResponseDTOList(
      List<Excursion> excursions);
}
