package org.scouthub.activitysender.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;
import org.scouthub.activitysender.domain.model.Activity;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityValue;

@Mapper(componentModel = "spring")
public interface ActivityKafkaMapper {
  ActivityValue activityToActivityValue(Activity activity);
}
