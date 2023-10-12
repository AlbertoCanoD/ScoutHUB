package org.scouthub.budgetgenerator;

import org.scouthub.budgetgenerator.infraestructure.kafka.BinderProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(BinderProcessor.class)
public class BudgetGeneratorApplication {
  public static void main(String[] args) {
    SpringApplication.run(BudgetGeneratorApplication.class, args);
  }
}
