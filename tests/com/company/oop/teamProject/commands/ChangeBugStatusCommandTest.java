package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugStatusCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeBugStatusCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeBugStatusCommand changeBugStatusCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeBugStatusCommand = new ChangeBugStatusCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeBugStatusCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeBugStatus_When_PassedValidInput() {
        Bug bug = repository.createNewBug("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", Priority.LOW, Severity.MINOR );

        List<String> params = List.of(String.valueOf(bug.getId()), "DONE");

        changeBugStatusCommand.execute(params);

        Assertions.assertEquals(EnumsForBugStatus.DONE, repository.getBugById(bug.getId()).getBugStatus());
    }
}
