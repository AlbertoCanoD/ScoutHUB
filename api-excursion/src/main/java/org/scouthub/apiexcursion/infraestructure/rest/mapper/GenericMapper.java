package org.scouthub.apiexcursion.infraestructure.rest.mapper;

import java.util.List;

public abstract class GenericMapper<T, D> implements Mapper<T, D> {

  @Override
  public List<D> entityListToDtoList(List<T> entities) {
    return entities.stream().map(this::entityToDto).toList();
  }

  @Override
  public List<T> dtoListToEntityList(List<D> dtos) {
    return dtos.stream().map(this::dtoToEntity).toList();
  }
}
