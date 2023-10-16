package org.scouthub.apiexcursion.infraestructure.kafka.mapper;

import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;

public interface Mapper<K, V, D> {
  ExcursionDTO toDTO(
          ExcursionKey excursionKey, ExcursionValue excursionValue, ExcursionDTO excursionDTO);

  D toDTO(K key, V value);
}
