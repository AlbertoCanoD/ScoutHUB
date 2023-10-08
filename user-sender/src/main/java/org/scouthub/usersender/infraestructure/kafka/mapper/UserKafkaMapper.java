package org.scouthub.usersender.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infraestructure.kafka.avro.UserValue;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserKafkaMapper {
  UserValue userToUserValue(User user);
}
