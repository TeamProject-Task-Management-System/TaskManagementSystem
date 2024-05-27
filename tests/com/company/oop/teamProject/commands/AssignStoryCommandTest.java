package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignBugCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignStoryCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssignStoryCommandTest {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private AssignStoryCommand assignStoryCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        assignStoryCommand = new AssignStoryCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> assignStoryCommand.execute(params));
    }

    @Test
    public void execute_Should_AssignNewStory_When_PassedValidInput() {
        repository.createNewStory("NNNNNNNNNNNNNN", "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", Priority.LOW, Size.SMALL);
        repository.createNewMember("FILIP");

        List<String> params = List.of(String.valueOf(1), "FILIP");

        assignStoryCommand.execute(params);

        Assertions.assertEquals(1, repository.getMemberByName("FILIP").getTasks().size());
    }
}
