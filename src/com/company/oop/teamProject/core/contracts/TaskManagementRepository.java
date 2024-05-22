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

    Bug createNewBug(String title, String description, Priority priority, Severity severity);

    Story createNewStory(String title, String description, Priority priority, Size size);

    Feedback createNewFeedback(String title, String description, int rating);

    Comment createComment(int taskId, String author, String description);

    Member getMemberByName(String memberName);

    Team getTeamByName(String teamName);

    Board getBoardByName(String name);

    Task getTaskByName (String name);

    Task getTaskById (int id);

    Bug getBugById(int id);

    Story getStoryById(int id);

    Feedback getFeedbackById(int id);

    String showAllMembers();

    String showAllTeams();

    String showAllBoards();

    String showAllTasks();

    String showAllTeamMembers(String teamName);

    public List<Member> getMembers();

    public List<Team> getTeams();

    public List<Task> getTasks();

    public List<Bug> getBugs();

    public List<Story> getStories();

    public List<Feedback> getFeedbacks();

    void assignBug(Bug bug, Member member);

    void assignStory(Story story, Member member);

    void unassignBug(Bug bug, Member member);

    void unassignStory(Story story, Member member);
}
