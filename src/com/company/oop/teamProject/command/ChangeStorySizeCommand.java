package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeStorySizeCommand extends BaseCommand{

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String STATUS_CHANGED = "Status with name %s changed.";


    public ChangeStorySizeCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Story story = getTaskManagementRepository().getStoryByTitle(parameters.get(0));
        Size newSize = ParsingHelpers.tryParseEnum(parameters.get(1), Size.class);

        story.changeSize(newSize);
        return String.format(STATUS_CHANGED, story.getTitle());

    }
}
