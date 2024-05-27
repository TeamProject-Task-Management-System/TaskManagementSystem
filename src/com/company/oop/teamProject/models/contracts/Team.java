package com.company.oop.teamProject.models.contracts;

import java.util.List;

public interface Team {

    String getName();

    List<Member> getTeamMembers();

    List<Board> getTeamBoards();

    String getHistory();

    void addMemberToTeam(Member member);

    void addBoardToTeam(Board board);
}
