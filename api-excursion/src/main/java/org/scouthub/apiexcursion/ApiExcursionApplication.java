package org.scouthub.apiexcursion;

import org.scouthub.apiexcursion.infraestructure.kafka.BinderProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class ApiExcursionApplication {
  public static void main(String[] args) {
    SpringApplication.run(ApiExcursionApplication.class, args);
  }
}
