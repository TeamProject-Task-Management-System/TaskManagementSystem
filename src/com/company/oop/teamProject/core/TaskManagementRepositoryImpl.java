package com.company.oop.teamProject.core;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.*;
import com.company.oop.teamProject.models.contracts.*;
import com.company.oop.teamProject.models.tasks.BugImpl;
import com.company.oop.teamProject.models.tasks.FeedbackImpl;
import com.company.oop.teamProject.models.tasks.StoryImpl;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository {

    private final List<Member> members;
    private final List<Team> teams;
    private final List<Bug> bugs;
    private final List<Story> stories;
    private final List<Feedback> feedbacks;

    int nextId;

    public TaskManagementRepositoryImpl() {
        nextId = 0;
        this.teams = new ArrayList<>();
        this.members = new ArrayList<>();
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
    }

    @Override
    public Team createNewTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                throw new IllegalArgumentException(String.format("Name %s already exist", name));
            }
        }
        Team team = new TeamImpl(name);
        teams.add(team);
        return team;
    }

    @Override
    public Member createNewMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                throw new IllegalArgumentException(String.format("Name %s already exist", name));
            }
        }
        Member member = new MemberImpl(name);
        members.add(member);
        return member;
    }

    @Override
    public void addMemberToTeam(Member memberToAdd, Team team) {
        if (team.getTeamMembers().contains(memberToAdd)) {
            throw new IllegalArgumentException(String.format("This member %s already exist in %s!", memberToAdd, team));
        }
        team.addMemberToTeam(memberToAdd);
    }

    @Override
    public Board createNewBoard(String name, Team team) {
        for (Board teamBoard : team.getTeamBoards()) {
            if (teamBoard.getName().equals(name)) {
                throw new IllegalArgumentException(String.format("Board with name %s already exist", name));
            }
        }
        Board board = new BoardImpl(name);
        team.addBoardToTeam(board);
        return board;
    }

    @Override
    public Bug createNewBug(String title, String description, Member assignee, Priority priority,
                            Severity severity) {
        Bug bug = new BugImpl(++nextId, title, description, assignee, priority, severity);
        bugs.add(bug);
        return bug;
    }

    @Override
    public Story createNewStory(String title, String description, Member assignee, Priority priority,
                                Size size) {
        Story story = new StoryImpl(++nextId, title, description, assignee, priority, size);
        stories.add(story);
        return story;
    }

    @Override
    public Feedback createNewFeedback(String title, String description, int rating) {
        Feedback feedback = new FeedbackImpl(++nextId, title, description, rating);
        feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String description) {
        return new CommentImpl(author, description);
    }

    @Override
    public Member getMemberByName(String memberName) {
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                return member;
            }
        }
        throw new IllegalArgumentException(String.format("There is not member with name %s", memberName));
    }

    @Override
    public Team getTeamByName(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        throw new IllegalArgumentException(String.format("There is not team with name %s", teamName));
    }

    @Override
    public Board getBoardByName(String name) {
        for (Team team : teams) {
            for (Board teamBoard : team.getTeamBoards()) {
                if (teamBoard.getName().equals(name)) {
                    return teamBoard;
                }
            }
        }
        throw new IllegalArgumentException(String.format("There is not board with name %s", name));
    }

    @Override
    public Bug getBugByTitle(String title) {
        for (Bug bug : bugs) {
            if (bug.getTitle().equals(title)){
                return bug;
            }
        }
        throw new IllegalArgumentException(String.format("There is no bug with title: %s", title));
    }

    @Override
    public Story getStoryByTitle(String title) {
        for (Story story : stories) {
            if (story.getTitle().equals(title)) {
                return story;
            }
        }
        throw new IllegalArgumentException(String.format("There is no story with title: %s", title));
    }

    @Override
    public Feedback getFeedbackByTitle(String title) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getTitle().equals(title)) {
                return feedback;
            }
        }
        throw new IllegalArgumentException(String.format("There is no feedback with title: %s", title));
    }

    @Override
    public String showAllMembers() {
        if (members.isEmpty()) {
            throw new IllegalArgumentException("There are no members!");
        }
        StringBuilder result = new StringBuilder();
        result.append("Members").append(":").append(System.lineSeparator());
        for (Member member : members) {
            result.append(member.getName()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    @Override
    public String showAllTeams() {
        if (teams.isEmpty()) {
            throw new IllegalArgumentException("There are no teams!");
        }
        StringBuilder result = new StringBuilder();
        result.append("Teams").append(":").append(System.lineSeparator());
        for (Team team : teams) {
            result.append(team.getName()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    @Override
    public String showAllBoards() {
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            if (team.getTeamBoards().isEmpty()) {
                System.out.printf("Team %s does not have any boards.", team);
                continue;
            }
            result.append("Team ").append(team.getName()).append("'s boards:").append(System.lineSeparator());
            for (Board teamBoard : team.getTeamBoards()) {
                result.append(teamBoard.getName()).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }

    @Override
    public String showAllTeamMembers(String teamName) {
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                result.append("Team ").append(team.getName()).append("'s members:").append(System.lineSeparator());
                for (Member member : team.getTeamMembers()) {
                    result.append(member.getName()).append("\n");
                }
                return result.toString().trim();
            }
        }
        throw new IllegalArgumentException(String.format("There is no team with name %s!", teamName));
    }

    public void assignBug(Bug bug, Member member){
        member.assignTask(bug);
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
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
