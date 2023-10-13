package org.scouthub.budgetgenerator.domain.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Embeddable
@Getter
@NoArgsConstructor
@Builder
public class BudgetPrimaryKey implements Serializable {
  Long activityId;
  Long materialId;
}
