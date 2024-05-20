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

public class TaskManagementRepositoryImpl implements TaskManagementRepository {


    private static final String MEMBER_ADDED_TO_TEAM_SUCC = "%s has been added to %s.";
    private static final String BUG_CREATED = "Bug with name %s created.";
    private static final String STORY_CREATED = "Story with name %s created.";
    private static final String FEEDBACK_CREATED = "Feedback with name %s created.";
    private static final String COMMENT_CREATED = "Created comment with author %s.";

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
        if (team.getTeamMembers().contains(memberToAdd)) {
            throw new IllegalArgumentException(String.format("This member %s already exist in %s!", memberToAdd, team));
        }
        team.addMemberToTeam(memberToAdd);
        System.out.println(String.format(MEMBER_ADDED_TO_TEAM_SUCC, memberToAdd, team));
    }

    @Override
    public Board createNewBoard(String name) {
        for (Team team : teams) {
            if (team.getTeamBoards().contains(name)) {
                throw new IllegalArgumentException(String.format("Board with name %s already exist", name));
            }
        }
        return new BoardImpl(name);
    }

    @Override
    public Bug createNewBug(String title, String description, Member assignee, Priority priority,
                            Severity severity) {

        return new BugImpl(++nextId, title, description, assignee, priority, severity);
    }

    @Override
    public Story createNewStory(int id, String title, String description, Member assignee, Priority priority,
                                Size size) {
        System.out.println(String.format(STORY_CREATED, title));
        return new StoryImpl(++nextId, title, description, assignee, priority, size);
    }

    @Override
    public Feedback createNewFeedback(int id, String title, String description, int rating) {
        System.out.println(String.format(FEEDBACK_CREATED, title));
        return new FeedbackImpl(++nextId, title, description, rating);
    }

    @Override
    public Comment createComment(String author, String description) {
        System.out.println(String.format(COMMENT_CREATED, author));
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
                if (teamBoard.equals(name)) {
                    return teamBoard;
                }
            }
        }
        throw new IllegalArgumentException(String.format("There is not board with name %s", name));
    }

    @Override
    public Bug getBugByID(int bugID) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugID) {
                return bug;
            }
        }
        throw new IllegalArgumentException(String.format("There is no bug with id: %d", bugID));
    }

    @Override
    public Story getStoryByID(int iD) {
        for (Story story : stories) {
            if (story.getId() == iD) {
                return story;
            }
        }
        throw new IllegalArgumentException(String.format("There is no story with id: %d", iD));
    }

    @Override
    public Feedback getFeedbackByID(int iD) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getId() == iD) {
                return feedback;
            }
        }
        throw new IllegalArgumentException(String.format("There is no feedback with id: %d", iD));
    }

    @Override
    public String showAllMembers() {
        if (members.isEmpty()) {
            throw new IllegalArgumentException("There are no members!");
        }
        StringBuilder result = new StringBuilder();
        for (Member member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String showAllTeams() {
        if (teams.isEmpty()) {
            throw new IllegalArgumentException("There are no teams!");
        }
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            result.append(team.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String showAllBoards() {
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            if (team.getTeamBoards().isEmpty()) {
                System.out.printf("Team %s does not have any boards.", team);
                continue;
            }
            for (Board teamBoard : team.getTeamBoards()) {
                result.append(teamBoard).append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    @Override
    public String showAllTeamMembers(String teamName) {
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                for (Member member : team.getTeamMembers()) {
                    result.append(member).append("\n");
                }
                return result.toString();
            }
        }
        throw new IllegalArgumentException(String.format("There is no team with name %s!", teamName));
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
