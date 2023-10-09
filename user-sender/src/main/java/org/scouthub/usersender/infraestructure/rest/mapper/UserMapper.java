package org.scouthub.usersender.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infraestructure.rest.dto.UserRequestDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User userRequestDTOToUser(UserRequestDTO userRequestDTO);
}
