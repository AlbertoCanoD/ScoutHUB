package org.scouthub.uservalidator.infraestructure.kafka;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface BinderProcessor {
  String USER = "user";

  String USER_VALIDATED = "user_validated";

  @Input(USER)
  KStream<?, ?> users();

  @Output(USER_VALIDATED)
  KStream<?, ?> users_validated();
}
