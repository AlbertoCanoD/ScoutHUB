package org.scouthub.activitysender.infraestructure.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.activitysender.domain.model.Activity;
import org.scouthub.activitysender.domain.service.ActivityService;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityKey;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityValue;
import org.scouthub.activitysender.infraestructure.kafka.mapper.ActivityKafkaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {
  static final String ACTIVITIES_TOPIC = "activity";

  @Autowired ActivityKafkaMapper activityKafkaMapper;

  @Autowired private KafkaTemplate<ActivityKey, ActivityValue> kafkaTemplate;

  @Override
  public void createActivity(Activity activity) {
    if (activity == null) {
      log.error("Abort, activity is null");
      return;
    }

    ActivityKey activityKey = new ActivityKey();
    activityKey.setId(activity.getId());
    ActivityValue activityValue = activityKafkaMapper.activityToActivityValue(activity);

    log.debug("Sending activity to kafka topic");
    kafkaTemplate.send(ACTIVITIES_TOPIC, activityKey, activityValue);
  }

  @Override
  public void deleteActivity(Long id) {
    ActivityKey activityKey = new ActivityKey(id);

    log.debug("Sending activity to kafka topic");
    kafkaTemplate.send(ACTIVITIES_TOPIC, activityKey, null);
  }
}
