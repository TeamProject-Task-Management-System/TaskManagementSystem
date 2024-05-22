package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.creationCommands.CreateMemberCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateMemberCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagementRepository repository;
    private CreateMemberCommand createMemberCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createMemberCommand = new CreateMemberCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createMemberCommand.execute(params));
    }

    @Test
    public void execute_Should_CreateNewMember_When_PassedValidInput() {
        List<String> params = List.of("Petar");

        createMemberCommand.execute(params);

        Assertions.assertEquals(1, repository.getMembers().size());
    }
}
