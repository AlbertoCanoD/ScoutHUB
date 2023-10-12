package org.scouthub.usersender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserSenderApplication {
  public static void main(String[] args) {
    SpringApplication.run(UserSenderApplication.class, args);
  }

  //  @Autowired private KafkaTemplate<UserKey, UserValue> kafkaTemplate;

  //  @EventListener(ContextRefreshedEvent.class)
  //  public void send() {
  //    UserKey key = UserKey.newBuilder().setId(2184194).build();
  //    UserValue value =
  //        UserValue.newBuilder()
  //            .setId(2184194)
  //            .setName("Raúl Javierre Cabrero")
  //            .setAge(10)
  //            .setBranch("castor")
  //            .build();
  //
  //    kafkaTemplate.send("user", key, value);
  //  }
}
