package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board {
    private static final int BOARD_NAME_MIN_LENGTH = 5;
    private static final int BOARD_NAME_MAX_LENGTH = 15;
    private static final String BOARD_NAME_ERR_MESSAGE = "Board name must be between 5 and 15";

    private String name;
    private List<Task> tasksList;
    private final List<EventLog> eventLogs = new ArrayList<>();

    public BoardImpl(String name) {
        setName(name);
        this.tasksList = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelper.validateIntRange(name.length(), BOARD_NAME_MIN_LENGTH, BOARD_NAME_MAX_LENGTH, BOARD_NAME_ERR_MESSAGE);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasksList);
    }

    @Override
    public void addTask(Task task) {
        tasksList.add(task);
    }

    protected void createNewEvent(String event) {
        eventLogs.add(new EventLogImpl(event));
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(eventLogs);
    }
}
