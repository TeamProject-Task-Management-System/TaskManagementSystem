package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.enums.EnumsForFeedbackStatus;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListFeedbackByStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Feedback> feedbacks;

    public ListFeedbackByStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        feedbacks = getTaskManagementRepository().getFeedbacks();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        EnumsForFeedbackStatus status = ParsingHelpers.tryParseEnum(parameters.get(0), EnumsForFeedbackStatus.class);
        return ListingHelper.elementsToString(filterNeeded(feedbacks ,status));
    }

    private List<Feedback> filterNeeded(List<Feedback> feedbacks, EnumsForFeedbackStatus status){
        return feedbacks
                .stream()
                .filter(feedback -> feedback.getFeedbackStatus().equals(status))
                .sorted(Comparator.comparing(feedback -> feedback.getTitle()))
                .sorted(Comparator.comparing(feedback -> feedback.getRating()))
                .collect(Collectors.toList());
    }
}
