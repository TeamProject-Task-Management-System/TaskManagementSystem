package com.company.oop.teamProject.command.changingCommandsForBug;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeBugSeverityCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String SEVERITY_CHANGED = "Bug %s's severity changed to %s";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeBugSeverityCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Bug title = getTaskManagementRepository().getBugById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        Severity severity = ParsingHelpers.tryParseEnum(parameters.get(1), Severity.class);

       title.changeSeverity(severity);
       return String.format(SEVERITY_CHANGED,title.getTitle(),severity);
    }
}
