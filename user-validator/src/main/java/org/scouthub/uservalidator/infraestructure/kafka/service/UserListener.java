package org.scouthub.uservalidator.infraestructure.kafka.service;

import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.uservalidator.application.CreateUser;
import org.scouthub.uservalidator.application.DeleteUser;
import org.scouthub.uservalidator.application.VerifyUser;
import org.scouthub.uservalidator.domain.model.User;
import org.scouthub.uservalidator.infraestructure.kafka.BinderProcessor;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserListener {
  @Autowired UserServiceImpl userService;

  @Autowired VerifyUser verifyUser;

  @StreamListener()
  @SendTo(BinderProcessor.USER_VALIDATED)
  public KStream<UserValidatedKey, UserValidatedValue> users(
      @Input(BinderProcessor.USER) KStream<UserKey, UserValue> users) {
    log.debug("User received by kafka topic");
    return users.flatMap(
        (userKey, userValue) -> {
          log.debug("UserKey {}, UserValue {}", userKey, userValue);
          List<KeyValue<UserValidatedKey, UserValidatedValue>> result = new LinkedList<>();
          if ((userValue == null)) {
            log.debug("User is a tombstone");
            DeleteUser.delete(userKey.getId(), userService);
            result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()), null));
          } else {
            log.debug("User is not a tombstone");

            User user =
                new User(
                    userValue.getId(),
                    userValue.getName(),
                    userValue.getAge(),
                    userValue.getBranch());

            // Verify age and branch
            if (!verifyUser.isValidUser(user)) {
              DeleteUser.delete(userKey.getId(), userService);
              result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()), null));
              return result;
            }

            CreateUser.create(user, userService);

            UserValidatedValue userValidatedValue =
                new UserValidatedValue(
                    userValue.getId(),
                    userValue.getName(),
                    userValue.getAge(),
                    userValue.getBranch());

            result.add(KeyValue.pair(new UserValidatedKey(userKey.getId()), userValidatedValue));
          }
          return result;
        });
  }
}
