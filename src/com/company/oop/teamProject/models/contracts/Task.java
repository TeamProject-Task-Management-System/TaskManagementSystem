package com.company.oop.teamProject.models.contracts;

import com.company.oop.teamProject.models.enums.Status;

public interface Task {

    String getTitle();

    String getDescription();

    Status getStatus();

    Comment getComments();

    EventLog getHistory();

    void addComment(Comment comment);
}
