package org.scouthub.activitysender.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.scouthub.activitysender.domain.model.Activity;
import org.scouthub.activitysender.infraestructure.rest.dto.ActivityRequestDTO;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
  Activity activityRequestDTOToActivity(ActivityRequestDTO activityRequestDTO);
}
