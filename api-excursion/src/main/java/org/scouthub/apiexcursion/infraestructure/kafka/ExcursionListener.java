package org.scouthub.apiexcursion.infraestructure.kafka;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.apiexcursion.infraestructure.kafka.mapper.ExcursionMapper;
import org.scouthub.apiexcursion.infraestructure.kafka.service.ExcursionService;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ExcursionListener {

  @Autowired ExcursionService excursionService;

  @Bean
  public Consumer<KStream<ExcursionKey, ExcursionValue>> process() {
    return excursionKStream ->
        excursionKStream
            .peek((k, v) -> log.info("Recibed excursion with key: {}", k))
            .peek((k, v) -> excursionService.create(new ExcursionMapper().toDTO(k, v)));
  }
}
