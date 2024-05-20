package com.company.oop.teamProject.command;

import com.company.oop.teamProject.command.contracts.Command;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;

import java.util.List;

public abstract class BaseCommand implements Command {

    private final TaskManagementRepository taskManagementRepository;

    protected BaseCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }

    protected TaskManagementRepository getTaskManagementRepository() {
        return taskManagementRepository;
    }

    public String execute(List<String> parameters) {
        return executeCommand(parameters);
    }

    protected abstract String executeCommand(List<String> parameters);
}
