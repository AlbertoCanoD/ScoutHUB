package org.scouthub.budgetgenerator.infraestructure.kafka.service;

import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityKey;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityValue;
import org.scouthub.budgetgenerator.application.CreateActivity;
import org.scouthub.budgetgenerator.application.DeleteActivity;
import org.scouthub.budgetgenerator.domain.model.Activity;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.ActivityService;
import org.scouthub.budgetgenerator.infraestructure.kafka.BinderProcessor;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActivityListener {
  @Autowired ActivityRepository activityRepository;

  @Autowired ActivityService activityService;

  @Autowired MaterialRepository materialRepository;

  @StreamListener()
  @SendTo(BinderProcessor.BUDGET)
  public KStream<BudgetKey, BudgetValue> activities(
      @Input(BinderProcessor.ACTIVITY) KStream<ActivityKey, ActivityValue> activityStream) {
    log.debug("Activity received by kafka topic");
    return activityStream.flatMap(
        (activityKey, activityValue) -> {
          log.debug("ActivityKey {}, ActivityValue {}", activityKey, activityValue);
          List<KeyValue<BudgetKey, BudgetValue>> result = new LinkedList<>();
          if ((activityValue == null)) { // Thombstone record
            DeleteActivity.delete(activityKey.getId(), activityRepository, activityService);
            result.add(KeyValue.pair(new BudgetKey(activityKey.getId()), null));
          } else {
            log.debug("Activity is not a tombstone");
            Activity activity =
                new Activity(
                    activityValue.getId(),
                    activityValue.getName(),
                    activityValue.getDescription(),
                    activityValue.getMaterialId(),
                    activityValue.getMaterialQuantity());
            CreateActivity.create(activity, activityRepository, activityService);
            float materialPrice =
                materialRepository.getReferenceById(activity.getMaterialId()).getPrice();
            float totalCost = materialPrice * activity.getMaterialQuantity();
            BudgetValue budgetValue =
                new BudgetValue(
                    activityValue.getId(),
                    activityValue.getName(),
                    activityValue.getMaterialId(),
                    activityValue.getMaterialQuantity(),
                    materialPrice,
                    totalCost);
            result.add(KeyValue.pair(new BudgetKey(activityKey.getId()), budgetValue));
          }
          return result;
        });
  }
}
