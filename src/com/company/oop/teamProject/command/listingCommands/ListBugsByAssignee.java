package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListBugsByAssignee extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Bug> bugs;

    public ListBugsByAssignee(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        bugs = getTaskManagementRepository().getBugs();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(0));
        return ListingHelper.elementsToString(filterNeeded(bugs, member));
    }

    private List<Bug> filterNeeded(List<Bug> bugs, Member member) {
        return bugs
                .stream()
                .filter(bug -> bug.getAssignee().equals(member))
                .sorted(Comparator.comparing(bug -> bug.getTitle()))
                .sorted(Comparator.comparing(bug -> bug.getBugPriority()))
                .sorted(Comparator.comparing(bug -> bug.getSeverity()))
                .collect(Collectors.toList());
    }
}
