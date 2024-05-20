package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Board {

    String getName();

    List<Task> getTasks();

    List<EventLog> getHistory();

    void addTask(Task task);

}
