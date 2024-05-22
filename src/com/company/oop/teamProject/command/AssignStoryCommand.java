package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.utils.ParsingHelpers;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.lang.reflect.Parameter;
import java.util.List;

public class AssignStoryCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String MEMBER_HAVE_ADDED_ASSIGN = "Story %s assigned to member %s.";
    private static final String ID_ERROR = "Id must be valid Integer";

    public AssignStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Story story = getTaskManagementRepository().getStoryById(ParsingHelpers.tryParseInt(parameters.get(0), ID_ERROR));
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(1));

        getTaskManagementRepository().assignStory(story, member);
        return String.format(MEMBER_HAVE_ADDED_ASSIGN, story.getTitle(), member.getName());
    }
}
