package org.scouthub.excursiongenerator.kafka;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Initializer
    implements org.apache.kafka.streams.kstream.Initializer<ActivitiesPerExcursionsValue> {
  @Override
  public ActivitiesPerExcursionsValue apply() {
    return ActivitiesPerExcursionsValue.newBuilder().setActivities(new ArrayList<>()).build();
  }
}
