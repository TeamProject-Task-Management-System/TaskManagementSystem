package com.company.oop.teamProject.command.addingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class AddMemberToTeamCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String MEMBER_ADDED_TO_TEAM_SUCC = "Member %s has been added to team %s.";

    public AddMemberToTeamCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(0));
        Team team = getTaskManagementRepository().getTeamByName(parameters.get(1));

        getTaskManagementRepository().addMemberToTeam(member, team);
        return String.format(MEMBER_ADDED_TO_TEAM_SUCC, member.getName(), team.getName());
    }
}
