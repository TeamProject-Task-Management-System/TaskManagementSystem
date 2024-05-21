package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateFeedbackCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private static final String FEEDBACK_CREATED = "Feedback with name %s created.";

    public CreateFeedbackCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = parameters.get(0);
        String description = parameters.get(1);
        int rating = ParsingHelpers.tryParseInt(parameters.get(2), "Can not be parsed to int");

        Feedback feedback = getTaskManagementRepository().createNewFeedback(title, description, rating);
        return String.format(FEEDBACK_CREATED, feedback.getTitle());
    }
}
