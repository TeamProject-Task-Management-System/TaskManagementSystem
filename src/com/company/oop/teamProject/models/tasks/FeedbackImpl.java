package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.utils.ValidationHelper;

public class FeedbackImpl extends TaskImpl implements Feedback {

    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final String TITLE_ERR_MESSAGE = "Title must be between 10 and 100";
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERR_MESSAGE = "Description must be between 10 and 500";


    private int rating;

    public FeedbackImpl(int id, String title, String description, Status status, int rating) {
        super(id, title, description, status);
        this.rating = rating;
    }

    @Override
    protected void validateTitle(String title) {
        ValidationHelper.validateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, TITLE_ERR_MESSAGE);
    }

    @Override
    protected void validateDescription(String description) {
        ValidationHelper.validateIntRange(description.length(), DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH, DESCRIPTION_ERR_MESSAGE);
    }

    @Override
    public void changeStatus(Status newStatus) {
        if (newStatus == this.status) {
            throw new IllegalArgumentException(String.format("Feedback status is already %s", status));
        }
        Status previousStatus = this.status;
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
}
