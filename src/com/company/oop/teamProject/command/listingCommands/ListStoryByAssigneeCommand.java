package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListStoryByAssigneeCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Story> stories;

    public ListStoryByAssigneeCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        stories = getTaskManagementRepository().getStories();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(0));
        return ListingHelper.elementsToString(filterNeeded(stories, member));
    }


    private List<Story> filterNeeded(List<Story> stories, Member member) {
        return stories
                .stream()
                .filter(story -> story.getAssignee().equals(member))
                .sorted(Comparator.comparing(story -> story.getTitle()))
                .sorted(Comparator.comparing(story -> story.getStoryPriority()))
                .sorted(Comparator.comparing(story -> story.getSize()))
                .collect(Collectors.toList());
}
