package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateBugCommand extends BaseCommand {

    private static final String BUG_CREATED = "Bug with name %s created.";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;

    public CreateBugCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(3), Severity.class);

        Bug bug = getTaskManagementRepository().createNewBug(title, description, priority, severity);
        return String.format(BUG_CREATED, bug.getTitle());
    }
}