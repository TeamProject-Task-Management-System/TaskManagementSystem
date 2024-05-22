package com.company.oop.teamProject.command.creationCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateMemberCommand extends BaseCommand {

    private static final String MEMBER_CREATED_SUCC = "Member with name %s created.";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public CreateMemberCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String name = parameters.get(0);
        Member member = getTaskManagementRepository().createNewMember(name);

        return String.format(MEMBER_CREATED_SUCC, member.getName());
    }
}
