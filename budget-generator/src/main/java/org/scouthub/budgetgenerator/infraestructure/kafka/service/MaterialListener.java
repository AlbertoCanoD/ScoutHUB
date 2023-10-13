package org.scouthub.budgetgenerator.infraestructure.kafka.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.budgetgenerator.application.CreateMaterial;
import org.scouthub.budgetgenerator.application.DeleteMaterial;
import org.scouthub.budgetgenerator.domain.model.Material;
import org.scouthub.budgetgenerator.domain.repository.ActivityRepository;
import org.scouthub.budgetgenerator.domain.repository.BudgetRepository;
import org.scouthub.budgetgenerator.domain.repository.MaterialRepository;
import org.scouthub.budgetgenerator.domain.service.BudgetService;
import org.scouthub.budgetgenerator.infraestructure.kafka.BinderProcessor;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialKey;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MaterialListener {
  @Autowired MaterialRepository materialRepository;

  @Autowired ActivityRepository activityRepository;

  @Autowired BudgetRepository budgetRepository;

  @Autowired
  BudgetService budgetService;

  @StreamListener
  @Profile({"default"})
  public void materials(
      @Input(BinderProcessor.MATERIAL) KStream<MaterialKey, MaterialValue> materials) {

    log.debug("Material received by kafka topic");
    materials.foreach(
        (materialKey, materialValue) -> {
          log.debug("MaterialKey {}, MaterialValue {}", materialKey, materialValue);
          if ((materialValue == null)) { // Thombstone record
            DeleteMaterial.delete(materialKey.getId(), materialRepository);
            return;
          }
          Material material =
              new Material(
                  materialValue.getId(), materialValue.getName(), materialValue.getQuantity());
          CreateMaterial.create(material, materialRepository);
        });
  }
}
