package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.EnumsForFeedbackStatus;

public interface Feedback extends Task {

    int getRating();

    void changeRating(int rating);

    void changeFeedbackStatus(EnumsForFeedbackStatus newStatus);

    EnumsForFeedbackStatus getFeedbackStatus();
}
