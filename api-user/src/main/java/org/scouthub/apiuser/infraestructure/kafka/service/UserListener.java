package org.scouthub.apiuser.infraestructure.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.apiuser.application.CreateUser;
import org.scouthub.apiuser.application.DeleteUser;
import org.scouthub.apiuser.domain.model.User;
import org.scouthub.apiuser.domain.repository.UserRepository;
import org.scouthub.apiuser.infraestructure.kafka.BinderProcessor;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserListener {

  @Autowired UserRepository userRepository;

  @StreamListener
  public void userValidated(
      @Input(BinderProcessor.USER) KStream<UserValidatedKey, UserValidatedValue> users) {
    users.foreach(
        (userValidatedKey, userValidatedValue) -> {
          if ((userValidatedValue == null)) {
            // Is a tombstone, so record must be deleted from database
            DeleteUser.delete(userValidatedKey.getId(), userRepository);
            return;
          }

          // Create user in database
          User user =
              new User(
                  userValidatedValue.getId(),
                  userValidatedValue.getName(),
                  userValidatedValue.getAge(),
                  userValidatedValue.getBranch());
          CreateUser.create(user, userRepository);
        });
  }
}
