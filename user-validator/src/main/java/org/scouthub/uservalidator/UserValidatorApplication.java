package org.scouthub.uservalidator;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValue;
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

    UserValidatedKey userValidatedKey = new UserValidatedKey(user.key().getId());
    UserValidatedValue userValidatedValue =
        new UserValidatedValue(
            user.value().getId(),
            user.value().getName(),
            user.value().getAge(),
            user.value().getBranch());

    //    boolean isValid = VerifyUser.isValidUser(userValidatedValue);

    //    UserValidatedKey key = new UserValidatedKey(1L);
    //    UserValidatedValue value = new UserValidatedValue(1L, "234234abrero", 10, "pino");
    //    kafkaTemplate.send("user_validated", key, value);

    kafkaTemplate.send("user_validated", userValidatedKey, userValidatedValue);

    // Referencair a produceMessage
    //    if (isValid) kafkaTemplate.send("user_validated", userValidatedKey, userValidatedValue);
    //    else kafkaTemplate.send("user_validated", userValidatedKey, null);
  }
}

  //  @EventListener(ContextRefreshedEvent.class)
//  public void produceMessage(UserValidatedKey key, UserValidatedValue value) {
//    kafkaTemplate.send("user_validated", key, value);
//  }
// }

  //    @KafkaListener(topics = "user")
  //    public void process(ConsumerRecord<UserKey, UserValue> user) {
  //      log.info(
  //          "Received message from topic {} in partition {} and offset {} with key {}",
  //          user.topic(),
  //          user.partition(),
  //          user.offset(),
  //          user.key());
  //    }
  //
  //  @Autowired
  //  private KafkaTemplate<UserValidatedKey, UserValidatedValue> kafkaTemplate;
  //
  //  @EventListener(ContextRefreshedEvent.class)
  //  public void send() {
  //    UserValidatedKey key = UserValidatedKey.newBuilder().setId(2184194).build();
  //    UserValidatedValue value =
  //            UserValidatedValue.newBuilder()
  //                    .setId(2184194)
  //                    .setName("Raúl Javierre Cabrero")
  //                    .setAge(10)
  //                    .setBranch("castor")
  //                    .build();
  //
  //    kafkaTemplate.send("user_validated", key, value);
  //  }
