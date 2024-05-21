package com.company.oop.teamProject.core.contracts;

import com.company.oop.teamProject.models.contracts.*;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.*;

import java.util.List;

public interface TaskManagementRepository {

    Member createNewMember(String name);

    Team createNewTeam(String name);

    void addMemberToTeam(Member memberToAdd, Team team);

    Board createNewBoard(String name, Team team);

    Bug createNewBug(String title, String description, Member assignee, Priority priority, Severity severity);

    Story createNewStory(String title, String description, Member assignee, Priority priority, Size size);

    Feedback createNewFeedback(String title, String description, int rating);

    Comment createComment(String author, String description);

    Member getMemberByName(String memberName);

    Team getTeamByName(String teamName);

    Board getBoardByName(String name);

    Bug getBugByID(int bugID);

    Story getStoryByID(int iD);

    Feedback getFeedbackByID(int iD);

    String showAllMembers();

    String showAllTeams();

    String showAllBoards();

    String showAllTeamMembers(String teamName);

    public List<Member> getMembers();

    public List<Team> getTeams();

    public List<Bug> getBugs();

    public List<Story> getStories();

    public List<Feedback> getFeedbacks();
}
