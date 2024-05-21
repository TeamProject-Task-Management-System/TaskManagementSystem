package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class UnassignStoryCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String MEMBER_HAVE_REMOVED_ASSIGN = "Story %s unassigned from member %s.";

    public UnassignStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        Story story = getTaskManagementRepository().getStoryByTitle(parameters.get(0));
        Member member = getTaskManagementRepository().getMemberByName(parameters.get(1));

        getTaskManagementRepository().unassignStory(story, member);
        return String.format(MEMBER_HAVE_REMOVED_ASSIGN, story.getTitle(), member.getName());
    }
}
