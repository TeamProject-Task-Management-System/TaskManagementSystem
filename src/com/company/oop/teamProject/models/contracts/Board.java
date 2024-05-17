package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Board {

    String getName();

    List<Task> getTasks();

    List<EventLog> getActivityHistory();

    void addTask(Task task);

    void addActivity(EventLog eventLog);
}
