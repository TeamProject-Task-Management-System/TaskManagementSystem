package com.company.oop.teamProject.core.contracts;

import com.company.oop.teamProject.models.contracts.*;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.contracts.Feedback;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.models.tasks.enums.Size;

public interface TaskManagementRepository {

    Member createNewPerson(String name);

    Team createNewTeam(String name);

    void addMemberToTeam(Member memberToAdd);

    Board createNewBoard(String name);

    Bug createNewBug(int id, String title, String description, Status status, Member assignee, Priority priority);

    Story createNewStory(int id, String title, String description, Status status, Member assignee, Priority priority, Size size);

    Feedback createNewFeedback(int id, String title, String description, Status status, int rating);

    Bug changeBugStatus(Status newStatus);

    Story changeStoryStatus(Status newStatus);

    Feedback changeFeedbackStatus(String newStatus);

    Bug changeBugPriority(Priority newPriority);

    Story changeStoryPriority(Priority newPriority);

    Bug changeSeverity(Severity newSeverity);

    Story changeSize(Size newSize);

    Feedback changeRating(int newRating);

    Comment addComment(String author, String description);

}
