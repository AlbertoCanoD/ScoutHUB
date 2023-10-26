package org.scouthub.apiexcursion.infraestructure.kafka.mapper;

import java.util.List;
import org.scouthub.apiexcursion.infraestructure.rest.dto.BudgetDTO;
import org.scouthub.apiexcursion.infraestructure.rest.dto.ExcursionDTO;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;

public class ExcursionMapper implements Mapper<ExcursionKey, ExcursionValue, ExcursionDTO> {

  @Override
  public ExcursionDTO toDTO(ExcursionKey key, ExcursionValue value) {
    List<BudgetDTO> budgets =
        value.getBudgets().stream()
            .map(
                b ->
                    BudgetDTO.builder()
                        .activityId(b.getActivityId())
                        .activityName(b.getActivityName())
                        .activityDescription(b.getActivityDescription())
                        .materialId(b.getMaterialId())
                        .materialName(b.getMaterialName())
                        .materialPrice(b.getMaterialPrice())
                        .materialQuantity(b.getMaterialQuantity())
                        .totalCost(b.getTotalCost())
                        .build())
            .toList();

    return ExcursionDTO.builder()
        .excursionId(key.getExcursionId())
        .totalPrice(value.getTotalPrice())
        .budgets(budgets)
        .build();
  }
}
