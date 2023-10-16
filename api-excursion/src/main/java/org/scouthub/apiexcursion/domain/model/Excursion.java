package org.scouthub.apiexcursion.domain.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Excursion {
  @Id UUID excursionId;
  float totalPrice;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  List<Budget> budgets;

  public Excursion(UUID excursionId, float totalPrice, List<org.scouthub.budgetgenerator.infraestructure.kafka.avro.Budget> budgets) {
  }
}
