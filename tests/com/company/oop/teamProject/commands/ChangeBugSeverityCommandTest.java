package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugSeverityCommand;
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

public class ChangeBugSeverityCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeBugSeverityCommand changeBugSeverityCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeBugSeverityCommand = new ChangeBugSeverityCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeBugSeverityCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeBugSeverity_When_PassedValidInput() {
        Bug bug = repository.createNewBug("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", Priority.LOW, Severity.MINOR );

        List<String> params = List.of(String.valueOf(bug.getId()), "MAJOR");

        changeBugSeverityCommand.execute(params);

        Assertions.assertEquals(Severity.MAJOR, repository.getBugById(bug.getId()).getSeverity());
    }
}
