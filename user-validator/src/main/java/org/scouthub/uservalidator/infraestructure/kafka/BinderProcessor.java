package org.scouthub.uservalidator.infraestructure.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BinderProcessor {
  String USER = "user";

  String USER_VALIDATED = "user_validated";

  @Input(USER)
  SubscribableChannel user();

  @Output(USER_VALIDATED)
  MessageChannel user_validated();
}
