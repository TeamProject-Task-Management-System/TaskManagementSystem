package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.BoardImpl;
import com.company.oop.teamProject.models.TeamImpl;
import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;

public class CreateBoardCommand extends BaseCommand{

    private static final String BOARD_CREATED_SUCC = "Board with name %s created.";
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    public CreateBoardCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String name = parameters.get(0);
        Team team = getTaskManagementRepository().getTeamByName(parameters.get(1));
        Board board = getTaskManagementRepository().createNewBoard(name, team);

        return String.format(BOARD_CREATED_SUCC, board.getName());
    }
}
