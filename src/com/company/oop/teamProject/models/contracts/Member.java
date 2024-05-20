package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Member {

    String getName();

    List<Task> getTasks();

    List<EventLog> getHistory();

    void assignTask(Task task);

    void unassignTask(Task task);
}
