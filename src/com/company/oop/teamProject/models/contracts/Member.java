package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Member {

    String getName();

    List<Task> getTasks();

    List<EventLog> getActivityHistory();

    void addTask();

    void addActivity();
}
