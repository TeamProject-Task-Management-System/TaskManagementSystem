package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.assignOrUnAssignCommands.UnassignBugCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.UnassignStoryCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnassignStoryCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private UnassignStoryCommand unassignStoryCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        unassignStoryCommand = new UnassignStoryCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> unassignStoryCommand.execute(params));
    }

    @Test
    public void execute_Should_UnassignStory_When_PassedValidInput() {
        Story story = repository.createNewStory("NNNNNNNNNNNN", "LLLLLLLLLLLLLLLLLLLL", Priority.LOW, Size.SMALL);
        repository.createNewMember("FILIP");
        repository.getMemberByName("FILIP").assignTask(story);

        List<String> params = List.of(String.valueOf(1), "FILIP");

        unassignStoryCommand.execute(params);

        Assertions.assertEquals(0, repository.getMemberByName("FILIP").getTasks().size());
    }
}
