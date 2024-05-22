package com.company.oop.teamProject.command.showCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;

import java.util.List;

public class ShowAllTasks extends BaseCommand {
    public ShowAllTasks(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return getTaskManagementRepository().showAllTasks();
    }
}
