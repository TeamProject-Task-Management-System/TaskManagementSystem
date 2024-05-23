package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugSeverityCommand;
import com.company.oop.teamProject.command.changingCommandsForStory.ChangeStorySizeCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeStorySizeCommandTest {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private ChangeStorySizeCommand changeStorySizeCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        changeStorySizeCommand = new ChangeStorySizeCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> changeStorySizeCommand.execute(params));
    }

    @Test
    public void execute_Should_ChangeBugSeverity_When_PassedValidInput() {
        Story story = repository.createNewStory("KKKKKKKKKKK", "LLLLLLLLLLLLLLLLLLL", Priority.LOW, Size.SMALL );

        List<String> params = List.of(String.valueOf(story.getId()), "LARGE");

        changeStorySizeCommand.execute(params);

        Assertions.assertEquals(Size.LARGE, repository.getStoryById(story.getId()).getSize());
    }
}
