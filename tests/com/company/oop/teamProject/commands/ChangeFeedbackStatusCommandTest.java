package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForFeedback.ChangeFeedbackStatusCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.enums.EnumsForFeedbackStatus;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeFeedbackStatusCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeFeedbackStatusCommand changeFeedbackStatusCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeFeedbackStatusCommand = new ChangeFeedbackStatusCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeFeedbackStatusCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeFeedbackStatus_When_PassedValidInput() {
        Feedback feedback = repository.createNewFeedback("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", 52 );

        List<String> params = List.of(String.valueOf(feedback.getId()), "DONE");

        changeFeedbackStatusCommand.execute(params);

        Assertions.assertEquals(EnumsForFeedbackStatus.DONE, repository.getFeedbackById(feedback.getId()).getFeedbackStatus());
    }
}
