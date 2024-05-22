package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeStoryStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String STORY_STATUS_CHANGED = "Story %s's status changed to %s";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeStoryStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Story story = getTaskManagementRepository().getStoryById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        EnumsForStoryStatus status = ParsingHelpers.tryParseEnum(parameters.get(1), EnumsForStoryStatus.class);
        story.changeStoryStatus(status);
        return String.format(STORY_STATUS_CHANGED, story.getTitle(), status);
    }
}
