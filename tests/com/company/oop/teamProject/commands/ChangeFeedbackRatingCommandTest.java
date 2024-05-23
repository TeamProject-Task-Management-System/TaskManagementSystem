package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForFeedback.ChangeFeedbackRatingCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeFeedbackRatingCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeFeedbackRatingCommand changeFeedbackRatingCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeFeedbackRatingCommand = new ChangeFeedbackRatingCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeFeedbackRatingCommand.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_RatingNotNumber() {
        List<String> params = List.of(String.valueOf(15),
                "invalid");


        Assertions.assertThrows(IllegalArgumentException.class, () -> changeFeedbackRatingCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeFeedbackRating_When_PassedValidInput() {
        Feedback feedback = repository.createNewFeedback("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", 51 );
        int id = feedback.getId();
        List<String> params = List.of(String.valueOf(feedback.getId()), String.valueOf(47));
        changeFeedbackRatingCommand.execute(params);

        Assertions.assertEquals(47, repository.getFeedbackById(id).getRating());
    }
}
