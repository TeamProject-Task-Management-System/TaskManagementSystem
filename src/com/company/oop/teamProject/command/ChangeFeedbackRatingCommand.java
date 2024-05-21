package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeFeedbackRatingCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String RATING_ERROR = "Rating must be valid Integer";
    private static final String FEEDBACK_RATING_CHANGED = "Feedback %s's rating changed to %d";

    public ChangeFeedbackRatingCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Feedback feedback = getTaskManagementRepository().getFeedbackByTitle(parameters.get(0));
        int rating = ParsingHelpers.tryParseInt(parameters.get(1), RATING_ERROR);

        feedback.changeRating(rating);
        return String.format(FEEDBACK_RATING_CHANGED, feedback.getTitle(), rating);
    }
}
