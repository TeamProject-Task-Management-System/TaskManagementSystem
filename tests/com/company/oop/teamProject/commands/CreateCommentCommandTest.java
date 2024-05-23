package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.creationCommands.CreateCommentCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateCommentCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private TaskManagementRepository repository;
    private CreateCommentCommand createCommentCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createCommentCommand = new CreateCommentCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createCommentCommand.execute(params));
    }

    @Test
    public void execute_Should_ThrowException_When_IdNotNumber() {
        List<String> params = List.of(
                "invalid",
                "Petar Grigorov", "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");


        Assertions.assertThrows(IllegalArgumentException.class, () -> createCommentCommand.execute(params));
    }

    @Test
    public void execute_Should_CreateNewTask_When_PassedValidInput() {
        Task task = repository.createNewBug("KKKKKKKKKKKK", "LLLLLLLLLLLLLLLLLL", Priority.LOW, Severity.MINOR);
        int id = task.getId();
        List<String> params = List.of(String.valueOf(id), "JKLKJPPKKkkkkk", "llllllllllllllllllllllllllllllllllllllllllllllll");

        createCommentCommand.execute(params);

        Assertions.assertEquals(1, repository.getTaskById(task.getId()).getComments().size());
    }
}
