package org.scouthub.usersender.infraestructure.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.usersender.domain.model.User;
import org.scouthub.usersender.domain.service.UserService;
import org.scouthub.usersender.infraestructure.kafka.avro.UserKey;
import org.scouthub.usersender.infraestructure.kafka.avro.UserValue;
import org.scouthub.usersender.infraestructure.kafka.mapper.UserKafkaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  static final String USERS_TOPIC = "user";

  @Autowired UserKafkaMapper userKafkaMapper;

  @Autowired private KafkaTemplate<UserKey, UserValue> kafkaTemplate;

  @Override
  public void createUser(User user) {
    if (user == null) {
      log.error("Abort, user is null");
      return;
    }

    UserKey userKey = new UserKey(user.getId());
    UserValue userValue = userKafkaMapper.userToUserValue(user);

    log.debug("Sending user to kafka topic");
    kafkaTemplate.send(USERS_TOPIC, userKey, userValue);
  }

  @Override
  public void deleteUser(Long id) {
    UserKey userKey = new UserKey(id);

    log.debug("Sending user to kafka topic");
    kafkaTemplate.send(USERS_TOPIC, userKey, null);
  }
}
