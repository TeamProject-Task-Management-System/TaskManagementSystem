package com.company.oop.teamProject.command.contracts;

import java.util.List;

public interface Command {

    String execute(List<String> parameters);
}
