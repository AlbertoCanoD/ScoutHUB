package org.scouthub.uservalidator.application;

import org.scouthub.uservalidator.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class VerifyUser {
    @Autowired
    private VerifyBranch verifyBranch;

    public  boolean VerifyUser(User user) {
        if (user.getAge() < 6) return false;
        return verifyBranch.VerifyBranch(user);
    }

}
