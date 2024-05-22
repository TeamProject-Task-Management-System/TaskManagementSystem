package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskImpl implements Task {

    private String title;
    private String description;
    private final List<Comment> comments = new ArrayList<>();
    private final List<EventLog> eventLogs = new ArrayList<>();

    public TaskImpl(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    private void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    private void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    protected abstract void validateTitle(String title);

    protected abstract void validateDescription(String description);

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
