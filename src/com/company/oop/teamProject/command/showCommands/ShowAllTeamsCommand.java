package com.company.oop.teamProject.command.showCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;

import java.util.List;

public class ShowAllTeamsCommand extends BaseCommand {
    public ShowAllTeamsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return getTaskManagementRepository().showAllTeams();
    }
}
