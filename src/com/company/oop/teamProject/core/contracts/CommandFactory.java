package com.company.oop.teamProject.core.contracts;

import com.company.oop.teamProject.command.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, VehicleDealershipRepository vehicleDealershipRepository);
}
