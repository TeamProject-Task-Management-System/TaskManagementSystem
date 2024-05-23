package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {
    private static final int MEMBER_NAME_MIN_LENGTH = 5;
    private static final int MEMBER_NAME_MAX_LENGTH = 15;
    private static final String MEMBER_NAME_ERR_MESSAGE = "Member name must be between 5 and 15";

    private String name;
    private List<Task> tasks;
    private final List<EventLog> eventLogs = new ArrayList<>();

    public MemberImpl(String name) {
        setName(name);
        this.tasks = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelper.validateIntRange(name.length() ,MEMBER_NAME_MIN_LENGTH, MEMBER_NAME_MAX_LENGTH, MEMBER_NAME_ERR_MESSAGE);
        this.name = name;
        createNewEvent(String.format("Member name set to %s", name));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void assignTask(Task task) {
        tasks.add(task);
        createNewEvent(String.format("Task with name %s has been assigned to %s.", task, name));
    }

    @Override
    public void unassignTask(Task task) {
        tasks.remove(task);
        createNewEvent(String.format("Task with name %s has been unassigned from %s.", task, name));
    }


    protected void createNewEvent(String event) {
        eventLogs.add(new EventLogImpl(event));
    }

    public String getHistory() {
        StringBuilder result = new StringBuilder();
        for (EventLog eventLog : eventLogs) {
            result.append(eventLog.getDescription()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
