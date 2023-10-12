package org.scouthub.apiuser.infraestructure.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.infraestructure.rest.dto.GetUserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
  GetUserResponseDTO userToGetUserResponseDTO(User user);

  List<GetUserResponseDTO> userListToGetUserResponseDTOList(List<User> users);
}
