package org.scouthub.budgetgenerator.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface BinderProcessor {
  String ACTIVITY = "activity";
  String MATERIAL = "material";
  String BUDGET = "budget";

  @Input(ACTIVITY)
  KStream<?, ?> activity();

  @Input(MATERIAL)
  KStream<?, ?> material();

  //  @Output(BUDGET)
  //  KStream<?, ?> budget();
}
