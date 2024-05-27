package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskImpl implements Task {

    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final String TITLE_ERR_MESSAGE = "Title must be between 10 and 100";
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERR_MESSAGE = "Description must be between 10 and 500";

    private String title;
    private String description;
    private final List<Comment> comments = new ArrayList<>();
    private final List<EventLog> eventLogs = new ArrayList<>();

    public TaskImpl(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    private void setTitle(String title) {
        ValidationHelper.validateIntRange(title.length(),
                TITLE_MIN_LENGTH,
                TITLE_MAX_LENGTH,
                TITLE_ERR_MESSAGE);
        this.title = title;
    }

    private void setDescription(String description) {
        ValidationHelper.validateIntRange(description.length(),
                DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH,
                DESCRIPTION_ERR_MESSAGE);
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    protected void createNewEvent(String event) {
        eventLogs.add(new EventLogImpl(event));
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(eventLogs);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
