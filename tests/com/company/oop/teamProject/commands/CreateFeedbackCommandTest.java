package com.company.oop.teamProject.commands;


import com.company.oop.teamProject.command.creationCommands.CreateFeedbackCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateFeedbackCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private TaskManagementRepository repository;
    private CreateFeedbackCommand createFeedbackCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createFeedbackCommand = new CreateFeedbackCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createFeedbackCommand.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_RatingNotNumber() {
        List<String> params = List.of("Jkfkfl", "JJJJJJJJJJJJJJJJJJJKKKK", "lll");

        Assertions.assertThrows(IllegalArgumentException.class, () -> createFeedbackCommand.execute(params));
    }

    @Test
    public void execute_Should_CreateNewFeedback_When_PassedValidInput() {
        List<String> params = List.of("TeamOOPPPPP", "KKKKKKKKKKKKKKK", String.valueOf(50));

        createFeedbackCommand.execute(params);

        Assertions.assertEquals(1, repository.getFeedbacks().size());
    }
}
