package org.scouthub.apiexcursion.infraestructure.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.apiexcursion.application.CreateExcursion;
import org.scouthub.apiexcursion.application.DeleteExcursion;
import org.scouthub.apiexcursion.domain.model.Excursion;
import org.scouthub.apiexcursion.domain.repository.ExcursionRepository;
import org.scouthub.apiexcursion.infraestructure.kafka.BinderProcessor;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ExcursionListener {

  @Autowired ExcursionRepository excursionRepository;

  @StreamListener
  public void excursion(
      @Input(BinderProcessor.EXCURSION) KStream<ExcursionKey, ExcursionValue> excursions) {
    excursions.foreach(
        (excursionKey, excursionValue) -> {
          if ((excursionValue == null)) {
            // Is a tombstone, so record must be deleted from database
            DeleteExcursion.delete(excursionKey.getId(), excursionRepository);
            return;
          }

          // Create excursion in database
          Excursion excursion = new Excursion(excursionValue.getId());
          CreateExcursion.create(excursion, excursionRepository);
        });
  }
}
