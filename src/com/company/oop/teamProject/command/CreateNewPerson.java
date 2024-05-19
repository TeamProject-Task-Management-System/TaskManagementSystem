package com.company.oop.teamProject.command;

import com.company.oop.teamProject.command.contracts.Command;
import com.company.oop.teamProject.models.contracts.Comment;

import java.util.List;

public class CreateNewPerson implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    @Override
    public String execute(List<String> parameters) {
        return null;
    }
}
