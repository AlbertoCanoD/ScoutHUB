package org.scouthub.budgetgenerator.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {
  String ACTIVITY = "activity";
  String MATERIAL = "material";

  @Input(ACTIVITY)
  KStream<?, ?> activity();

  @Input(MATERIAL)
  KStream<?, ?> material();
}
