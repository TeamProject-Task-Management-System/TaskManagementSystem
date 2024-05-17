package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl extends TeamImpl implements Board {
    private List<Task> tasksList = new ArrayList<>();
    private List<EventLog> activityHistory = new ArrayList<>();

    public BoardImpl(String name) {
        super(name);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasksList);
    }

    @Override
    public List<EventLog> getActivityHistory() {
        return new ArrayList<>(activityHistory);
    }

    @Override
    public void addTask(Task task) {
        tasksList.add(task);
    }

    @Override
    public void addActivity(EventLog eventLog) {
        activityHistory.add(eventLog);
    }
}
