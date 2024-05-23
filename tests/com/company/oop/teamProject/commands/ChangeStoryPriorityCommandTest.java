package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStoryPriorityCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeStoryPriorityCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeStoryPriorityCommand changeStoryPriorityCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeStoryPriorityCommand = new ChangeStoryPriorityCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeStoryPriorityCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeStoryPriority_When_PassedValidInput() {
        Story story = repository.createNewStory("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", Priority.LOW, Size.LARGE );

        List<String> params = List.of(String.valueOf(story.getId()), "MEDIUM");

        changeStoryPriorityCommand.execute(params);

        Assertions.assertEquals(Priority.MEDIUM, repository.getStoryById(story.getId()).getStoryPriority());
    }
}
