package com.company.oop.teamProject.command.changingCommandsForFeedback;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeFeedbackRatingCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String RATING_ERROR = "Rating must be valid Integer";
    private static final String FEEDBACK_RATING_CHANGED = "Feedback %s's rating changed to %d";
    private static final String ID_ERROR = "Id must be valid Integer";

    public ChangeFeedbackRatingCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Feedback feedback = getTaskManagementRepository()
                .getFeedbackById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        int rating = ParsingHelpers.tryParseInt(parameters.get(1), RATING_ERROR);

        feedback.changeRating(rating);
        return String.format(FEEDBACK_RATING_CHANGED, feedback.getTitle(), rating);
    }
}
