package org.scouthub.excursiongenerator.kafka;

import java.util.UUID;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetKey;
import org.scouthub.budgetgenerator.infraestructure.kafka.avro.BudgetValue;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionKey;
import org.scouthub.excursiongenerator.infraestructure.kafka.avro.ExcursionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BudgetAggregator {
  @Autowired Aggregator aggregator;
  @Autowired Initializer initializer;

  @Bean
  public Function<KStream<BudgetKey, BudgetValue>, KStream<ExcursionKey, ExcursionValue>>
      aggregateBudgets() {
    return budgetsStream ->
        budgetsStream
            .peek(
                (k, v) -> log.info("[aggregateBudgets] Recibed budget -> key: {}, value: {}", k, v))
            .selectKey(
                (k, v) -> ExcursionKey.newBuilder().setExcursionId(UUID.randomUUID()).build())
            .groupByKey()
            .aggregate(initializer, aggregator)
            .toStream()
            .peek(
                (k, v) ->
                    log.info("[aggregateBudgets] Budgets aggregateds -> key: {}, value: {}", k, v));
  }
}
