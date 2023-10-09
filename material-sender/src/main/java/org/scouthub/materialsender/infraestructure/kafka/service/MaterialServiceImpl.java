package org.scouthub.materialsender.infraestructure.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.scouthub.materialsender.domain.model.Material;
import org.scouthub.materialsender.domain.service.MaterialService;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialKey;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialValue;
import org.scouthub.materialsender.infraestructure.kafka.mapper.MaterialKafkaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MaterialServiceImpl implements MaterialService {
  final String MATERIALS_TOPIC = "material";

  @Autowired MaterialKafkaMapper materialKafkaMapper;

  @Autowired private KafkaTemplate<MaterialKey, MaterialValue> kafkaTemplate;

  @Override
  public void createMaterial(Material material) {
    if (material == null) {
      log.error("Abort, material is null");
      return;
    }

    MaterialKey materialKey = new MaterialKey();
    materialKey.setId(material.getId());
    MaterialValue materialValue = materialKafkaMapper.materialToMaterialValue(material);

    log.debug("Sending material to kafka topic");
    kafkaTemplate.send(MATERIALS_TOPIC, materialKey, materialValue);
  }

  @Override
  public void deleteMaterial(Long id) {
    MaterialKey materialKey = new MaterialKey(id);

    log.debug("Sending material to kafka topic");
    kafkaTemplate.send(MATERIALS_TOPIC, materialKey, null);
  }
}
