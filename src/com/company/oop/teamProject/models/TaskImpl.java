package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.enums.Status;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskImpl implements Task {

    private int id;
    private String title;
    private String description;
    private final Status status;
    private final List<Comment> comments = new ArrayList<>();
    private final List<EventLog> eventLogs = new ArrayList<>();

    public TaskImpl(int id, String title, String description, Status status) {
        this.id = id;
        setTitle(title);
        setDescription(description);
        this.status = status;
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

    public abstract void advanceStatus(Status status);
    public abstract void revertStatus(Status status);

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }


    public List<EventLog> getHistory() {
        return new ArrayList<>(eventLogs);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getId() {
        return id;
    }
}
