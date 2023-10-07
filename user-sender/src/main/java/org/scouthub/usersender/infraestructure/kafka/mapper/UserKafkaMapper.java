package org.scouthub.usersender.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infrastructure.kafka.avro.UserValue;

@Mapper(componentModel = "spring")
public interface UserKafkaMapper {
    UserValue userToUserValue(User user);
}
