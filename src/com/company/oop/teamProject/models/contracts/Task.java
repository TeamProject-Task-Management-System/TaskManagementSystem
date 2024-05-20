package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Task extends Identifiable {

    String getTitle();

    String getDescription();

    List<Comment> getComments();

    List<EventLog> getHistory();
}
