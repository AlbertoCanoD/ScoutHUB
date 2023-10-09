package org.scouthub.materialsender.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.scouthub.materialsender.domain.model.Material;
import org.scouthub.materialsender.infraestructure.rest.dto.MaterialRequestDTO;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
  Material materialRequestDTOToMaterial(MaterialRequestDTO materialRequestDTO);
}
