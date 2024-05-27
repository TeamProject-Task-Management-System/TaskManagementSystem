package com.company.oop.teamProject.commands;


import com.company.oop.teamProject.command.addingCommands.AddMemberToTeamCommand;
import com.company.oop.teamProject.command.changingCommandsForBug.ChangeBugPriorityCommand;
import com.company.oop.teamProject.core.TaskManagementRepositoryImpl;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.MemberImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddMemberToTeamCommandTest {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagementRepository repository;
    private AddMemberToTeamCommand addMemberToTeamCommand;

    @BeforeEach
    public void before() {
        repository = new TaskManagementRepositoryImpl();
        addMemberToTeamCommand = new AddMemberToTeamCommand(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        List<String> params = TestUtilities.getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        assertThrows(IllegalArgumentException.class, () -> addMemberToTeamCommand.execute(params));
    }

    @Test
    public void testExecuteCommand_withNonexistentMember() {
        repository.createNewTeam("Developers");

        List<String> parameters = new ArrayList<>();
        parameters.add("NonexistentMember");
        parameters.add("Developers");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            addMemberToTeamCommand.execute(parameters);
        });

        assertEquals("There is not member with name NonexistentMember", exception.getMessage());
    }

    @Test
    public void testExecuteCommand_withNonexistentTeam() {
        repository.createNewMember("George");

        List<String> parameters = new ArrayList<>();
        parameters.add("George");
        parameters.add("NonexistentTeam");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            addMemberToTeamCommand.execute(parameters);
        });

        assertEquals("There is not team with name NonexistentTeam", exception.getMessage());
    }

    @Test
    public void execute_Should_ChangeBugPriority_When_PassedValidInput() {
        Member member = repository.createNewMember("Henry");
        Team team = repository.createNewTeam("TheTeam15");

        repository.addMemberToTeam(member, team);

        Assertions.assertEquals(1, repository.getTeamByName("TheTeam15").getTeamMembers().size());
    }
}


