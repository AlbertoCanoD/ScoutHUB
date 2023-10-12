package org.scouthub.budgetgenerator.domain.service;

import org.scouthub.budgetgenerator.domain.model.Activity;

public interface ActivityService {
    void createActivity(Activity activity);

    void deleteActivity(Long id);
}
