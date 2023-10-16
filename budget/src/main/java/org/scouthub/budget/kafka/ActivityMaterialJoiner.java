package org.scouthub.budget.kafka;

import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityKey;
import org.scouthub.activitysender.infraestructure.kafka.avro.ActivityValue;
import org.scouthub.budget.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budget.infraestructure.kafka.avro.BudgetValue;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialKey;
import org.scouthub.materialsender.infraestructure.kafka.avro.MaterialValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ActivityMaterialJoiner {
  @Bean
  public BiFunction<
          KStream<ActivityKey, ActivityValue>,
          KStream<MaterialKey, MaterialValue>,
          KStream<BudgetKey, BudgetValue>>
      bugetJoiner() {
    return (activityStream, materialStream) -> {
      KTable<BudgetKey, ActivityValue> activityKTable =
          activityStream
              //                  .toTable(Named.as("ACTIVITY"), Materialized.as("ACTIVITY"));
              .selectKey((k, v) -> BudgetKey.newBuilder().setActivityId(k.getId()).build())
              .toTable(Named.as("BUDGET_ACTIVITY"), Materialized.as("BUDGET_ACTIVITY"));

      KTable<BudgetKey, MaterialValue> materialKTable =
          materialStream
              //                  .toTable(Named.as("MATERIAL"), Materialized.as("MATERIAL"));
              .selectKey((k, v) -> BudgetKey.newBuilder().setActivityId(k.getId()).build())
              .toTable(Named.as("BUDGET_MATERIAL"), Materialized.as("BUDGET_MATERIAL"));

      return activityKTable
          .join(
              materialKTable,
              (activityValue, materialValue) ->
                  BudgetValue.newBuilder()
                      .setActivityId(activityValue.getId())
                      .setMaterialId(materialValue.getId())
                      .build())
          .toStream()
          .peek((k, v) -> log.info("Create budget -> clave: {} valor: {}", k, v));

      //      return activityKTable
      //          .join(
      //              materialKTable,
      //              (activityValue, materialValue) -> {
      //                BudgetValue budgetValue = new BudgetValue();
      //                budgetValue.setActivityId(activityValue.getId());
      //                budgetValue.setActivityName(activityValue.getName());
      //                budgetValue.setActivityDescription(activityValue.getDescription());
      //                //                budgetValue.setMaterialId(materialValue.getId());
      //                //                budgetValue.setMaterialName(materialValue.getName());
      //                //                budgetValue.setMaterialPrice(materialValue.getPrice());
      //                return budgetValue;
      //              })
      //          .toStream()
      //          .map((k, v) -> new KeyValue<>(new BudgetKey(k.getId()), v))
      //          .peek((k, v) -> log.info("Created budget entry -> key: {} value: {}", k, v));
    };
  }
}
