package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.EventLog;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Team {
    private static final int TEAM_NAME_MIN_LENGTH = 5;
    private static final int TEAM_NAME_MAX_LENGTH = 15;
    private static final String TEAM_NAME_ERR_MESSAGE = "Team name must be between 5 and 15";

    private String name;

    private final List<Member> teamMembers = new ArrayList<>();
    private final List<Board> teamBoards = new ArrayList<>();
    private final List<EventLog> eventLogs = new ArrayList<>();

    public TeamImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        ValidationHelper.validateIntRange(name.length(), TEAM_NAME_MIN_LENGTH,
                TEAM_NAME_MAX_LENGTH, TEAM_NAME_ERR_MESSAGE);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public List<Member> getTeamMembers() {
        return new ArrayList<>(teamMembers);
    }

    @Override
    public List<Board> getTeamBoards() {
        return new ArrayList<>(teamBoards);
    }

    @Override
    public void addMemberToTeam(Member member) {
        if (teamMembers.contains(member)) {
            throw new IllegalArgumentException(String.format("There is already a member in the team with name %s", member));
        }
        teamMembers.add(member);
        createNewEvent(String.format("Member %s has been added to team %s", member, this.name));
    }

    @Override
    public void addBoardToTeam(Board board) {
        if (teamBoards.contains(board)) {
            throw new IllegalArgumentException(String.format("There is already a board in the team with name %s", board));
        }
        teamBoards.add(board);
        createNewEvent(String.format("Board %s has been added to team %s", board, this.name));
    }

    protected void createNewEvent(String event) {
        eventLogs.add(new EventLogImpl(event));
    }

    public List<EventLog> getHistory() {
        return new ArrayList<>(eventLogs);
    }
}
