package org.scouthub.activitysender.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
  Long id;
  String name;
  String description;
  Long materialId;
  int quantity;
}
