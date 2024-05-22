package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeBugPriorityCommand extends BaseCommand{

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String BUG_PRIORITY_CHANGED = "Bug %s's priority changed to %s";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeBugPriorityCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Bug title = getTaskManagementRepository().getBugById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR) );
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(1), Priority.class);

        title.changePriority(priority);
        return String.format(BUG_PRIORITY_CHANGED,title.getTitle(),priority);
    }
}
