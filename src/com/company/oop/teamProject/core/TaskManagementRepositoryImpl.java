package com.company.oop.teamProject.core;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.BoardImpl;
import com.company.oop.teamProject.models.MemberImpl;
import com.company.oop.teamProject.models.TeamImpl;
import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.Comment;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.models.enums.Status;
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

public class TaskManagementRepositoryImpl implements TaskManagementRepository{

    private final List<Member> members = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    int nextId;

    public TaskManagementRepositoryImpl(){
        nextId = 0;
    }

    @Override
    public Member createNewPerson(String name) {
        return new MemberImpl(name);
    }

    @Override
    public Team createNewTeam(String name) {
        return new TeamImpl(name);
    }

    @Override
    public void addMemberToTeam(Member memberToAdd) {
        if(members.contains(memberToAdd)){
            throw new IllegalArgumentException(String.format("This member %s already exist!", memberToAdd));
        }
        members.add(memberToAdd);
    }

    @Override
    public Board createNewBoard(String name) {
        return new BoardImpl(name);
    }

    @Override
    public Bug createNewBug(int id, String title, String description, Status status, Member assignee, Priority priority) {
        return new BugImpl(++nextId, title, description, status, assignee, priority);
    }

    @Override
    public Story createNewStory(int id, String title, String description, Status status, Member assignee, Priority priority, Size size) {
        return new StoryImpl(++nextId, title, description, status, assignee, priority, size);
    }

    @Override
    public Feedback createNewFeedback(int id, String title, String description, Status status, int rating) {
        return new FeedbackImpl(++nextId, title, description, status, rating);
    }

    @Override
    public void changeBugStatus(Status newStatus) {
        ;
    }

    @Override
    public void changeStoryStatus(Status newStatus) {
    }

    @Override
    public void changeFeedbackStatus(String newStatus) {
    }

    @Override
    public void changeBugPriority(Priority newPriority) {
    }

    @Override
    public void changeStoryPriority(Priority newPriority) {
    }

    @Override
    public void changeSeverity(Severity newSeverity) {
    }

    @Override
    public void changeSize(Size newSize) {
    }

    @Override
    public void changeRating(int newRating) {
    }

    @Override
    public Comment addComment(String author, String description) {
        return null;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }
}
