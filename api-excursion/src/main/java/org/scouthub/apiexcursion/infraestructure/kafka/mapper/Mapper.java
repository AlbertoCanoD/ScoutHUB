package org.scouthub.apiexcursion.infraestructure.kafka.mapper;

public interface Mapper<K, V, D> {
  D toDTO(K key, V value);
}
