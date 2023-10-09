package org.scouthub.uservalidator.application;

import org.scouthub.uservalidator.domain.model.Branch;
import org.scouthub.uservalidator.domain.model.User;

public class VerifyBranch {
  public static boolean isBranchValid(User user) {
    String branch = user.getBranch();
    return switch (Branch.valueOf(branch.toUpperCase())) {
      case BEAVER, CUB, RANGER, PIONEER, SCOUTER -> true;
      default -> false;
    };
  }

  public boolean isAgeInRange(User user) {
    int age = user.getAge();
    String branch = user.getBranch();

    return switch (Branch.valueOf(branch.toUpperCase())) {
      case BEAVER -> age >= 6 && age <= 8;
      case CUB -> age >= 9 && age <= 11;
      case RANGER -> age >= 12 && age <= 14;
      case PIONEER -> age >= 15 && age <= 19;
      case SCOUTER -> age >= 20 && age <= 100;
      default -> false;
    };
  }

  public boolean VerifyBranch(User user) {
    return isBranchValid(user) && isAgeInRange(user);
  }
}
