package org.scouthub.usersender;

import org.scouthub.usersender.infrastructure.kafka.avro.UserKey;
import org.scouthub.usersender.infrastructure.kafka.avro.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class UserSenderApplication {

  @Autowired private KafkaTemplate<UserKey, UserValue> kafkaTemplate;

  public static void main(String[] args) {
    SpringApplication.run(UserSenderApplication.class, args);
  }

  @EventListener(ContextRefreshedEvent.class)
  public void send() {
    UserKey key = UserKey.newBuilder().setId(2184194).build();
    UserValue value =
        UserValue.newBuilder()
            .setId(2184194)
            .setName("Raúl Javierre Cabrero")
            .setAge(10)
            .setBranch("castor")
            .build();

    kafkaTemplate.send("user", key, value);
  }
}
