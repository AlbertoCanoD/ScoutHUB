package org.scouthub.materialsender.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Material {
  Long id;
  String name;
  int quantity;
  float price;
}
