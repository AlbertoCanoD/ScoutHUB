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
public class Material {
  @Id Long id;
  String name;
  float price;

  @OneToOne(mappedBy = "material", cascade = CascadeType.ALL)
  Budget budget;

  public Material(Long id, String name, float price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}
