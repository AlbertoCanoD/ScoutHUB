package org.scouthub.uservalidator;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.scouthub.usersender.infraestructure.kafka.avro.UserKey;
import org.scouthub.usersender.infraestructure.kafka.avro.UserValue;
import org.scouthub.uservalidator.application.VerifyUser;
import org.scouthub.uservalidator.domain.exception.BranchDoesNotExist;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@Slf4j
public class UserValidatorApplication {
  @Autowired private KafkaTemplate<UserValidatedKey, UserValidatedValue> kafkaTemplate;

  public static void main(String[] args) {
    SpringApplication.run(UserValidatorApplication.class, args);
  }

  @KafkaListener(topics = "user")
  public void consumeAndProduceMessage(
      @Payload(required = false) ConsumerRecord<UserKey, UserValue> user)
      throws BranchDoesNotExist {
    log.info(
        "Received message from topic {} in partition {} and offset {} with key {}",
        user.topic(),
        user.partition(),
        user.offset(),
        user.key());

    log.info("UserKey: {} and UserValue: {}", user.key(), user.value());

    // Send Tombstone record if the user is null
    if (user.value() == null) {
      log.info("Delete User {}", user.key().getId());
      kafkaTemplate.send("user_validated", new UserValidatedKey(user.key().getId()), null);
      return;
    }

    UserValidatedKey userValidatedKey = new UserValidatedKey(user.key().getId());
    UserValidatedValue userValidatedValue =
        new UserValidatedValue(
            user.value().getId(),
            user.value().getName(),
            user.value().getAge(),
            user.value().getBranch());

    // If the user is valid send the message
    if (VerifyUser.isValidUser(userValidatedValue)) {
      log.info("User {} is valid", userValidatedKey.getId());
      kafkaTemplate.send("user_validated", userValidatedKey, userValidatedValue);
    }
  }
}
