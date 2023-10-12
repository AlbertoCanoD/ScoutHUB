package org.scouthub.apiuser.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface BinderProcessor {
  String USER = "user_validated";

  @Input(USER)
  KStream<?, ?> user_validated();
}
