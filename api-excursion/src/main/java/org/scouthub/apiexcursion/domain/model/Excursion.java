package org.scouthub.apiexcursion.domain.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Excursion {
  @Id UUID excursionId;
  float totalPrice;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  List<Budget> budgets;

  public Excursion(UUID excursionId, float totalPrice, List<Budget> budgets) {}
}
