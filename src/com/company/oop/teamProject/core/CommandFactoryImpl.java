package com.company.oop.teamProject.core;

import com.company.oop.teamProject.command.CreateBoardCommand;
import com.company.oop.teamProject.command.CreateBugCommand;
import com.company.oop.teamProject.command.CreateMemberCommand;
import com.company.oop.teamProject.command.CreateTeamCommand;
import com.company.oop.teamProject.command.contracts.Command;
import com.company.oop.teamProject.command.contracts.enums.CommandType;
import com.company.oop.teamProject.core.contracts.CommandFactory;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.utils.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskManagementRepository taskManagementRepository) {
        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString, CommandType.class);

        switch (commandType) {
            case CREATEMEMBER:
                return new CreateMemberCommand(taskManagementRepository);
            case CREATETEAM:
                return new CreateTeamCommand(taskManagementRepository);
            case CREATEBOARD:
                return new CreateBoardCommand(taskManagementRepository);
            case CREATEBUG:
                return new CreateBugCommand(taskManagementRepository);
            default:
                throw new IllegalArgumentException();
        }
    }
}
