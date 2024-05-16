package com.company.oop.teamProject.models.contracts;

import com.company.oop.teamProject.models.enums.Status;

import java.util.List;

public interface Task extends Identifiable {

    String getTitle();

    String getDescription();

    Status getStatus();

    List<Comment> getComments();

    List<EventLog> getHistory();

    void addComment(Comment comment);

    void advanceStatus(Status status);
    void revertStatus(Status status);
}
