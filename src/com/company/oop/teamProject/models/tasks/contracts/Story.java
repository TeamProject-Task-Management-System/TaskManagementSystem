package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;

public interface Story extends Task, Assignable {

    Size getSize();

    void changeStoryStatus(EnumsForStoryStatus newStatus);

    void changeSize(Size newSize);

    void changePriority(Priority priority);

    void setAssignee(Member assignee);

    Member getAssignee();

    EnumsForStoryStatus getStoryStatus();

    Priority getStoryPriority();
}
