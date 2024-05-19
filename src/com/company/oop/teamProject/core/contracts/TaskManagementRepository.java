package com.company.oop.teamProject.core.contracts;

import com.company.oop.teamProject.models.contracts.*;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;

import java.util.ArrayList;
import java.util.List;

public interface TaskManagementRepository {

    Member createNewPerson(String name);

    Team createNewTeam(String name);

    void addMemberToTeam(Member memberToAdd);

    Board createNewBoard(String name);

    Bug createNewBug(int id, String title, String description, Status status, Member assignee, Priority priority);

    Story createNewStory(int id, String title, String description, Status status, Member assignee, Priority priority, Size size);

    Feedback createNewFeedback(int id, String title, String description, Status status, int rating);

    void changeBugStatus(Status newStatus);

    void changeStoryStatus(Status newStatus);

    void changeFeedbackStatus(String newStatus);

    void changeBugPriority(Priority newPriority);

    void changeStoryPriority(Priority newPriority);

    void changeSeverity(Severity newSeverity);

    void changeSize(Size newSize);

    void changeRating(int newRating);

    Comment addComment(String author, String description);

    public List<Member> getMembers();

    public List<Board> getBoards();

}
