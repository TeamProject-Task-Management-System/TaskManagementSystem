package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListStoryByStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Story> stories;

    public ListStoryByStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        stories = getTaskManagementRepository().getStories();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        EnumsForStoryStatus status = ParsingHelpers.tryParseEnum(parameters.get(0), EnumsForStoryStatus.class);
        return ListingHelper.elementsToString(filterNeeded(stories, status));

    }

    private List<Story> filterNeeded(List<Story> stories, EnumsForStoryStatus status) {
        return stories
                .stream()
                .filter(story -> story.getStoryStatus().equals(status))
                .sorted(Comparator.comparing(story -> story.getTitle()))
                .sorted(Comparator.comparing(story -> story.getStoryPriority()))
                .sorted(Comparator.comparing(story -> story.getSize()))
                .collect(Collectors.toList());

    }
}
