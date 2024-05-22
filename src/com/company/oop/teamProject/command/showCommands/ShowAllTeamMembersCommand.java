package com.company.oop.teamProject.command.showCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ShowAllTeamMembersCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public ShowAllTeamMembersCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Team team = getTaskManagementRepository().getTeamByName(parameters.get(0));

        return getTaskManagementRepository().showAllTeamMembers(team.getName());
    }
}
