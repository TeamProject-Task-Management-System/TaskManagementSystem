package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class AddMemberToTeamCommand extends BaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String MEMBER_ADDED_TO_TEAM_SUCC = "%s has been added to %s.";

    public AddMemberToTeamCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(0));
        Team team = getTaskManagementRepository().getTeamByName(parameters.get(1));

        getTaskManagementRepository().addMemberToTeam(member, team);
        return String.format(MEMBER_ADDED_TO_TEAM_SUCC, member);
    }
}
