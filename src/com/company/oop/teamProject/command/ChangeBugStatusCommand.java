package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeBugStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String BUG_STATUS_CHANGED = "Bug %s's status changed to %s";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeBugStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Bug bug = getTaskManagementRepository().getBugById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        EnumsForBugStatus status = ParsingHelpers.tryParseEnum(parameters.get(1), EnumsForBugStatus.class);

        bug.changeBugStatus(status);
        return String.format(BUG_STATUS_CHANGED, bug.getTitle(), status);
    }
}
