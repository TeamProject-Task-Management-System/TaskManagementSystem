package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateStoryCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    private static final String STORY_CREATED = "Story with name %s created.";

    protected CreateStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String title = parameters.get(0);
        String description = parameters.get(1);
        Member assignee = getTaskManagementRepository().getMemberByName(parameters.get(2));
        Priority priority = ParsingHelpers.tryParseEnum(parameters.get(3), Priority.class);
        Size size = ParsingHelpers.tryParseEnum(parameters.get(4), Size.class);

        Story story = getTaskManagementRepository().createNewStory(title, description, assignee, priority, size);
        return String.format(STORY_CREATED, story);
    }
}
