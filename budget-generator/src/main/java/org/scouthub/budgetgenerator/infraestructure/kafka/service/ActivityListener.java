package org.scouthub.budgetgenerator.infraestructure.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityKey;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityValue;
import org.scouthub.budgetgenerator.application.CreateActivity;
import org.scouthub.budgetgenerator.application.DeleteActivity;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.infraestructure.kafka.BinderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SuppressWarnings("ALL")
@Component
@Slf4j
public class ActivityListener {
  @Autowired ActivityRepository activityRepository;

  @StreamListener()
  @Profile({"default"})
  public void activities(
      @Input(BinderProcessor.ACTIVITY) KStream<ActivityKey, ActivityValue> activities) {
    log.debug("Activity received by kafka topic");
    activities.foreach(
        (activityKey, activityValue) -> {
          log.debug("ActivityKey {}, ActivityValue {}", activityKey, activityValue);
          if ((activityValue == null)) { // Thombstone record
            DeleteActivity.delete(activityKey.getId(), activityRepository);
            return;
          }
          Activity activity =
              new Activity(
                  activityValue.getId(), activityValue.getName(), activityValue.getDescription());
          CreateActivity.create(activity, activityRepository);
        });
  }
}
