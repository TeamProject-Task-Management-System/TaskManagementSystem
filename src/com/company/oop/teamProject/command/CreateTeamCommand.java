package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.MemberImpl;
import com.company.oop.teamProject.models.TeamImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateTeamCommand extends BaseCommand{

    private static final String TEAM_CREATED_SUCC = "Team with name %s crated.";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public CreateTeamCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String name = parameters.get(0);
        Team team = getTaskManagementRepository().createNewTeam(name);

        return String.format(TEAM_CREATED_SUCC, team.getName());
    }
}
