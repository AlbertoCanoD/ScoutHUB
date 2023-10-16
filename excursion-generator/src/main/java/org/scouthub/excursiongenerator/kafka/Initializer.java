package org.scouthub.excursiongenerator.kafka;

import java.util.ArrayList;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements org.apache.kafka.streams.kstream.Initializer<ExcursionValue> {
  @Override
  public ExcursionValue apply() {
    return ExcursionValue.newBuilder().setBudgets(new ArrayList<>()).build();
  }
}
