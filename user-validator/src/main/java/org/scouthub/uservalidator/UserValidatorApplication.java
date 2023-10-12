package org.scouthub.uservalidator;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.scouthub.usersender.infraestructure.kafka.avro.UserKey;
import org.scouthub.usersender.infraestructure.kafka.avro.UserValue;
import org.scouthub.uservalidator.application.VerifyUser;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

// @Configuration
@SpringBootApplication
// @EnableBinding(BinderProcessor.class)
@Slf4j
public class UserValidatorApplication {
  @Autowired private KafkaTemplate<UserValidatedKey, UserValidatedValue> kafkaTemplate;

  public static void main(String[] args) {
    SpringApplication.run(UserValidatorApplication.class, args);
  }

  @KafkaListener(topics = "user")
  public void consumeMessage(ConsumerRecord<UserKey, UserValue> user) {
    log.info(
        "Received message from topic {} in partition {} and offset {} with key {}",
        user.topic(),
        user.partition(),
        user.offset(),
        user.key());
    log.info("");
    log.info("UserKey: {} and UserValue: {}", user.key(), user.value());

    //    kafkaTemplate.send("user_validated", user.key(), user.value());

    UserValidatedKey userValidatedKey = new UserValidatedKey(user.key().getId());
    UserValidatedValue userValidatedValue =
        new UserValidatedValue(
            user.value().getId(),
            user.value().getName(),
            user.value().getAge(),
            user.value().getBranch());

    boolean isValid = VerifyUser.isValidUser(userValidatedValue);

    if (isValid) kafkaTemplate.send("user_validated", userValidatedKey, userValidatedValue);

    //    UserValidatedKey key = new UserValidatedKey(user.key().getId());
    //    UserValidatedValue value = new UserValidatedValue(key.getId(), "234234abrero", 10,
    // "pino");
    //    kafkaTemplate.send("user_validated", key, value);

  }
}
