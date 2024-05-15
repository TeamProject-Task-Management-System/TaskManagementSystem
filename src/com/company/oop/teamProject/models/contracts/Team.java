package com.company.oop.teamProject.models.contracts;

import java.lang.reflect.Member;
import java.util.List;

public interface Team {

    String getName();

    List<Member> getMembers();

    List<Board> getBoards();

    void addMember(Member member);

    void addBoard(Board board);
}
