package org.scouthub.budgetgenerator.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
  @Id Long id;
  String name;
  String description;
}
