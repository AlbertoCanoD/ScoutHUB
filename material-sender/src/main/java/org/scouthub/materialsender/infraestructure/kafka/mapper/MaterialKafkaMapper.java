package org.scouthub.materialsender.infraestructure.kafka.mapper;

import org.mapstruct.Mapper;
import org.scouthub.materialsender.domain.model.Material;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialValue;

@Mapper(componentModel = "spring")
public interface MaterialKafkaMapper {
    MaterialValue materialToMaterialValue(Material material);
}
