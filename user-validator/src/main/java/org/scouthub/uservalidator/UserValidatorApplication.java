package org.scouthub.uservalidator;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.scouthub.uservalidator.infraestructure.kafka.BinderProcessor;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedKey;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValidatedValue;
import org.scouthub.uservalidator.infraestructure.kafka.avro.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
@Slf4j
public class UserValidatorApplication {
  public static void main(String[] args) {
    SpringApplication.run(UserValidatorApplication.class, args);
  }

    @KafkaListener(topics = "user")
    public void process(ConsumerRecord<UserKey, UserValue> user) {
      log.info(
          "Received message from topic {} in partition {} and offset {} with key {}",
          user.topic(),
          user.partition(),
          user.offset(),
          user.key());
    }
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
}
