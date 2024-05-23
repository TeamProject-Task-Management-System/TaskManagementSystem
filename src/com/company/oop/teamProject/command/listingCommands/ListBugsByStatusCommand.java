package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListBugsByStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Bug> bugs;

    public ListBugsByStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        bugs = getTaskManagementRepository().getBugs();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        EnumsForBugStatus status = ParsingHelpers.tryParseEnum(parameters.get(0), EnumsForBugStatus.class);
        return ListingHelper.elementsToString(filterNeeded(bugs, status));
    }

    private List<Bug> filterNeeded(List<Bug> bugs, EnumsForBugStatus status) {
        return bugs
                .stream()
                .filter(bug -> bug.getBugStatus().equals(status))
                .sorted(Comparator.comparing(bug -> bug.getTitle()))
                .sorted(Comparator.comparing(bug -> bug.getBugPriority()))
                .sorted(Comparator.comparing(bug -> bug.getSeverity()))
                .collect(Collectors.toList());
    }
}
