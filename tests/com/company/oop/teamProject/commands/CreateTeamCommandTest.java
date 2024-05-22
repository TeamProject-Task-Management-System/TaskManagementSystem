package com.company.oop.teamProject.commands;

import com.company.oop.teamProject.command.CreateTeamCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CreateTeamCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagementRepository repository;
    private CreateTeamCommand createTeamCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        createTeamCommand = new CreateTeamCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> createTeamCommand.execute(params));
    }

}
