package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.enums.EnumsForFeedbackStatus;
import com.company.oop.teamProject.utils.ValidationHelper;

public class FeedbackImpl extends TaskImpl implements Feedback {

    private int id;
    private int rating;
    private EnumsForFeedbackStatus status;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(title, description);
        this.id = id;
        this.rating = rating;
        this.status = EnumsForFeedbackStatus.NEW;
    }

    @Override
    public void changeFeedbackStatus(EnumsForFeedbackStatus newStatus) {
        if (newStatus == this.status) {
            throw new IllegalArgumentException(String.format("Feedback status is already %s", status));
        }
        EnumsForFeedbackStatus previousStatus = this.status;
        this.status = newStatus;
        createNewEvent(String.format("Feedback status changed from %s to %s", previousStatus, status));
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public void changeRating(int newRating) {
        int previousRating = rating;
        this.rating = newRating;
        createNewEvent(String.format("Feedback rating changed from %s to %s", previousRating, rating));
    }

    @Override
    public int getId() {
        return id;
    }

    public EnumsForFeedbackStatus getFeedbackStatus() {
        return status;
    }

    @Override
    public String getAsString() {
        return """
                Feedback ID: %d %s
                Description:
                %s
                Rating: %d
                Status: %s
                """.formatted(id, getTitle(), getDescription(), rating, status);
    }
}
