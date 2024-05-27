package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.assignOrUnAssignCommands.AssignBugCommand;
import com.company.oop.teamProject.command.creationCommands.CreateBugCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.MemberImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.BugImpl;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssignBugCommandTest {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private AssignBugCommand assignBugCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        assignBugCommand = new AssignBugCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> assignBugCommand.execute(params));
    }

    @Test
    public void execute_Should_AssignNewBug_When_PassedValidInput() {
        repository.createNewBug("NNNNNNNNNNNN", "LLLLLLLLLLLLLLLLLLLL", Priority.LOW, Severity.MINOR);
        repository.createNewMember("FILIP");

        List<String> params = List.of(String.valueOf(1), "FILIP");

        assignBugCommand.execute(params);

        Assertions.assertEquals(1, repository.getMemberByName("FILIP").getTasks().size());
    }
}
