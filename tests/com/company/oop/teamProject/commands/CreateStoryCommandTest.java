package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.creationCommands.CreateStoryCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateStoryCommandTest {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private TaskManagementRepository repository;
    private CreateStoryCommand createStoryCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createStoryCommand = new CreateStoryCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createStoryCommand.execute(params));
    }

    @Test
    public void execute_Should_AddNewTeam_When_PassedValidInput() {

        List<String> params = List.of("TeamOOPPPPP", "KKKKKKKKKKKKKKK", "MEDIUM", "LARGE");

        createStoryCommand.execute(params);

        Assertions.assertEquals(1, repository.getStories().size());
    }

}
