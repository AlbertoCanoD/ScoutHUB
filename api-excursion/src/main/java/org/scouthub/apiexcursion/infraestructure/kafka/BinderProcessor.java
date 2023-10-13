package org.scouthub.apiexcursion.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {
  String EXCURSION = "excursion";

  @Input(EXCURSION)
  KStream<?, ?> excursion();
}
