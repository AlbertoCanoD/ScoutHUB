package org.scouthub.uservalidator.infraestructure.kafka.service;

import org.scouthub.uservalidator.domain.model.User;
import org.scouthub.uservalidator.domain.service.UserService;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  String USER_VALIDATED = "user_validated";

  @Autowired private KafkaTemplate<UserValidatedKey, UserValidatedValue> kafkaTemplate;

  @Override
  public void createUser(User user) {
    UserValidatedKey userValidatedKey = new UserValidatedKey();
    userValidatedKey.setId(user.getId());

    UserValidatedValue userValidatedValue =
        new UserValidatedValue(user.getId(), user.getName(), user.getAge(), user.getBranch());
    kafkaTemplate.send(USER_VALIDATED, userValidatedKey, userValidatedValue);
  }

  @Override
  public void deleteUser(Long id) {
    UserValidatedKey userValidatedKey = new UserValidatedKey();
    userValidatedKey.setId(id);
    kafkaTemplate.send(USER_VALIDATED, userValidatedKey, null);
  }
}
