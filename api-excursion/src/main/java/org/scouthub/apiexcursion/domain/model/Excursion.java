package org.scouthub.apiexcursion.domain.model;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {
  @Id Long id;
}
