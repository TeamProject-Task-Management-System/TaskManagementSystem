package com.company.oop.teamProject.core;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.BoardImpl;
import com.company.oop.teamProject.models.CommentImpl;
import com.company.oop.teamProject.models.MemberImpl;
import com.company.oop.teamProject.models.TeamImpl;
import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.models.tasks.BugImpl;
import com.company.oop.teamProject.models.tasks.FeedbackImpl;
import com.company.oop.teamProject.models.tasks.StoryImpl;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.*;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository{

    private final List<Member> members;
    private final List<Board> boards;
    private final List<Team> teams;
    private final List<Bug> bugs;
    private final List<Story> stories;
    private final List<Feedback> feedbacks;

    int nextId;

    public TaskManagementRepositoryImpl(){
        nextId = 0;
        this.teams = new ArrayList<>();
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    @Override
    public Team createNewTeam(String name) {
        if (teams.contains(name)) {
            throw new IllegalArgumentException(String.format("Name %s already exist", name));
        }
        return new TeamImpl(name);
    }

    @Override
    public Member createNewMember(String name) {
        if (members.contains(name)) {
            throw new IllegalArgumentException(String.format("Name %s already exist", name));
        }
        return new MemberImpl(name);
    }

    @Override
    public void addMemberToTeam(Member memberToAdd, Team team) {
        if(team.getTeamMembers().contains(memberToAdd)){
            throw new IllegalArgumentException(String.format("This member %s already exist in %s!", memberToAdd, team));
        }
        team.addMemberToTeam(memberToAdd);
    }

    @Override
    public Board createNewBoard(String name) {
        if (boards.contains(name)) {
            throw new IllegalArgumentException(String.format("Board with name %s already exist", name));
        }
        return new BoardImpl(name);
    }

    @Override
    public Bug createNewBug(String title, String description, Member assignee, Priority priority, Severity severity) {
        return new BugImpl(++nextId, title, description, assignee, priority, severity);
    }

    @Override
    public Story createNewStory(int id, String title, String description, Member assignee, Priority priority, Size size) {
        return new StoryImpl(++nextId, title, description, assignee, priority, size);
    }

    @Override
    public Feedback createNewFeedback(int id, String title, String description, int rating) {
        return new FeedbackImpl(++nextId, title, description, rating);
    }

    @Override
    public Comment createComment(String author, String description) {
        return new CommentImpl(author, description);
    }

    @Override
    public Member getMemberByName(String memberName) {
        for(Member member : members){
            if(member.getName().equals(memberName)){
                return member;
            }
        }
        throw new IllegalArgumentException(String.format("There is not member with name %s", memberName));
    }

    @Override
    public Team getTeamByName(String teamName) {
        for(Team team : teams){
            if(team.getName().equals(teamName)){
                return team;
            }
        }
        throw new IllegalArgumentException(String.format("There is not team with name %s", teamName));
    }

    @Override
    public Board getBoardByName(String name) {
        for(Board board : boards){
            if(board.getName().equals(name)){
                return board;
            }
        }
        throw new IllegalArgumentException(String.format("There is not board with name %s", name));
    }

    @Override
    public Bug getBugByID(int bugID) {
        for (Bug bug : bugs){
            if(bug.getId() == bugID){
                return bug;
            }
        }
        throw new IllegalArgumentException(String.format("There is no bug with id: %d", bugID));
    }

    @Override
    public Story getStoryByID(int ID) {
        return null;
    }

    @Override
    public Feedback getFeedbackByID(int ID) {
        return null;
    }

    @Override
    public String showAllMembers() {
        return "";
    }

    @Override
    public String showAllTeams() {
        return "";
    }

    @Override
    public String showAllBoards() {
        return "";
    }

    @Override
    public String showAllTeamMembers(String teamName) {
        return "";
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public List<Bug> getBugs() {
        return new ArrayList<>(bugs);
    }

    public List<Story> getStories() {
        return new ArrayList<>(stories);
    }

    public List<Feedback> getFeedbacks() {
        return new ArrayList<>(feedbacks);
    }
}
