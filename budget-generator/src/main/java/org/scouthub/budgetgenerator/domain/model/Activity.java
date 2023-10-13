package org.scouthub.budgetgenerator.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
  @Id Long id;
  String name;
  String description;

  @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
  Budget budget;

  public Activity(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
