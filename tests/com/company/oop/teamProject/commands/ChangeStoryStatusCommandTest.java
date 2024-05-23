package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStoryStatusCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeStoryStatusCommandTest {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeStoryStatusCommand changeStoryStatusCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeStoryStatusCommand = new ChangeStoryStatusCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeStoryStatusCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeStoryStatus_When_PassedValidInput() {
        Story story = repository.createNewStory("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", Priority.LOW, Size.SMALL );

        List<String> params = List.of(String.valueOf(story.getId()), "DONE");

        changeStoryStatusCommand.execute(params);

        Assertions.assertEquals(EnumsForStoryStatus.DONE, repository.getStoryById(story.getId()).getStoryStatus());
    }
}
