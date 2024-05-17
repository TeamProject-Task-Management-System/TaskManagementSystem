package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl extends TeamImpl implements Member {
    private List<Task> tasks;
    private List<EventLog> activityHistory;

    public MemberImpl(String name) {
        super(name);
        tasks = new ArrayList<>();
        activityHistory = new ArrayList<>();
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<EventLog> getActivityHistory() {
        return new ArrayList<>(activityHistory);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void addActivity(EventLog eventLog) {
        activityHistory.add(eventLog);
    }


}
