package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateCommentCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String COMMENT_CREATED = "Created comment with author %s.";

    public CreateCommentCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String author = parameters.get(0);
        String description = parameters.get(1);

        Comment comment = getTaskManagementRepository().createComment(author,description);
        return String.format(COMMENT_CREATED, comment);
    }
}
