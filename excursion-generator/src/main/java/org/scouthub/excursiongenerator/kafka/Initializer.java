package org.scouthub.excursiongenerator.kafka;

import java.util.ArrayList;
import java.util.UUID;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements org.apache.kafka.streams.kstream.Initializer<ExcursionValue> {
  @Override
  public ExcursionValue apply() {
    return ExcursionValue.newBuilder()
        .setExcursionId(UUID.randomUUID())
        .setTotalPrice(0.0f)
        .setBudgets(new ArrayList<>())
        .build();
  }
}
