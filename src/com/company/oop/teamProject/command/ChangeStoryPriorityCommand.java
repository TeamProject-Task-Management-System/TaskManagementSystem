package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeStoryPriorityCommand extends BaseCommand{

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String STORY_PRIORITY_CHANGED = "Story %s's priority changed to %s";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeStoryPriorityCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        Story story = getTaskManagementRepository().getStoryById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(1),Priority.class);

        story.changePriority(priority);
        return String.format(STORY_PRIORITY_CHANGED, story.getTitle(), priority);
    }
}
