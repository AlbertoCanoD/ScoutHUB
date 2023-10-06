package org.scouthub.usersender.infraestructure.kafka.mapper;

import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.infrastructure.kafka.avro.UserValue;

public interface UserKafkaMapper {
    UserValue userToUserValue(User user);
}
