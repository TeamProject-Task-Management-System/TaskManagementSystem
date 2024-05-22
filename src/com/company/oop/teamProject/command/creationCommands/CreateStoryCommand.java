package com.company.oop.teamProject.command.creationCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateStoryCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private static final String STORY_CREATED = "Story with name %s created.";

    public CreateStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String title = parameters.get(0);
        String description = parameters.get(1);
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(2), Priority.class);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(3), Size.class);

        Story story = getTaskManagementRepository().createNewStory(title, description, priority, size);
        return String.format(STORY_CREATED, story.getTitle());
    }
}
