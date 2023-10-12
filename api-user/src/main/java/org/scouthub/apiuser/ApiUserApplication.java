package org.scouthub.apiuser;

import org.scouthub.apiuser.infraestructure.kafka.BinderProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class ApiUserApplication {
  public static void main(String[] args) {
    SpringApplication.run(ApiUserApplication.class, args);
  }
}
