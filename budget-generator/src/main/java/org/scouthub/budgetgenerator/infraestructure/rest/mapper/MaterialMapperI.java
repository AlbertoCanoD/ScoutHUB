package org.scouthub.budgetgenerator.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.infraestructure.rest.dto.GetMaterialResponseDTO;

@Mapper(componentModel = "spring")
public interface MaterialMapperI {
  GetMaterialResponseDTO materialToGetMaterialResponseDTO(Material material);

  List<GetMaterialResponseDTO> materialListToGetMaterialResponseDTOList(List<Material> materials);
}
