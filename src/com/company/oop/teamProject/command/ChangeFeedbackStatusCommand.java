package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.enums.EnumsForFeedbackStatus;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class ChangeFeedbackStatusCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String FEEDBACK_STATUS_CHANGED = "Feedback %s's status changed to %s";

    public ChangeFeedbackStatusCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Feedback feedback = getTaskManagementRepository().getFeedbackByTitle(parameters.get(0));
        EnumsForFeedbackStatus status = ParsingHelpers.tryParseEnum(parameters.get(1), EnumsForFeedbackStatus.class);

        feedback.changeFeedbackStatus(status);
        return String.format(FEEDBACK_STATUS_CHANGED, feedback.getTitle(), status);
    }
}
