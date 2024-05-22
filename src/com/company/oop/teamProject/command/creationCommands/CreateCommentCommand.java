package com.company.oop.teamProject.command.creationCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateCommentCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private static final String COMMENT_CREATED = "Created comment with author %s.";
    private static final String ID_ERROR = "Id must be valid Integer.";

    public CreateCommentCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        int id = ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR);
        String author = parameters.get(1);
        String description = parameters.get(2);

        Comment comment = getTaskManagementRepository().createComment(id, author, description);
        return String.format(COMMENT_CREATED, comment);
    }
}
