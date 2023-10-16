package org.scouthub.budgetgenerator.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetActivityResponseDTO;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
  GetActivityResponseDTO activityToGetActivityResponseDTO(Activity activity);

  List<GetActivityResponseDTO> activityListToGetActivityResponseDTOList(List<Activity> activities);
}
