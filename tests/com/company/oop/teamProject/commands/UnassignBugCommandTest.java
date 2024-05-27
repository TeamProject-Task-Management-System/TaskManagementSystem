package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignBugCommand;
import com.company.oop.teamProject.command.assignOrUnAssignCommands.UnassignBugCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnassignBugCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private UnassignBugCommand unassignBugCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        unassignBugCommand = new UnassignBugCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> unassignBugCommand.execute(params));
    }

    @Test
    public void execute_Should_UnassignBug_When_PassedValidInput() {
        Bug bug = repository.createNewBug("NNNNNNNNNNNN", "LLLLLLLLLLLLLLLLLLLL", Priority.LOW, Severity.MINOR);
        repository.createNewMember("FILIP");
        repository.getMemberByName("FILIP").assignTask(bug);

        List<String> params = List.of(String.valueOf(1), "FILIP");

        unassignBugCommand.execute(params);

        Assertions.assertEquals(0, repository.getMemberByName("FILIP").getTasks().size());
    }
}
