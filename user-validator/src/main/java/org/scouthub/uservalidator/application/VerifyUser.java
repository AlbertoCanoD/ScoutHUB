package org.scouthub.uservalidator.application;

import org.scouthub.uservalidator.domain.model.Branch;
import org.scouthub.uservalidator.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyUser {
  public boolean isValidUser(User user) {
    String branch = user.getBranch();
    int age = user.getAge();
    Branch userBranch = Branch.valueOf(branch.toUpperCase());

    return switch (userBranch) {
      case BEAVER -> age >= 6 && age <= 8;
      case CUB -> age >= 9 && age <= 11;
      case RANGER -> age >= 12 && age <= 14;
      case PIONEER -> age >= 15 && age <= 19;
      case SCOUTER -> age >= 20 && age <= 100;
      default -> false;
    };
  }
}
