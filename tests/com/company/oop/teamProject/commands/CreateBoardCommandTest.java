package com.company.oop.teamProject.commands;


import com.company.oop.teamProject.command.creationCommands.CreateBoardCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateBoardCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private CreateBoardCommand createBoardCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createBoardCommand = new CreateBoardCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createBoardCommand.execute(params));
    }

    @Test
    public void execute_Should_CreateNewBoard_When_PassedValidInput() {
        repository.createNewTeam("Team12345");

        List<String> params = List.of("TeamOOPPPPP", "Team12345");

        createBoardCommand.execute(params);

        Assertions.assertEquals(1, repository.getTeamByName("Team12345").getTeamBoards().size());
    }
}
