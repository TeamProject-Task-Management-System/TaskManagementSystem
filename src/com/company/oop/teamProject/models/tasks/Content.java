package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Assignable;
import com.company.oop.teamProject.models.tasks.contracts.Prioritizable;
import com.company.oop.teamProject.models.tasks.enums.Priority;

public abstract class Content extends TaskImpl implements Assignable, Prioritizable {
    private final Member assignee;
    private final Priority priority;

    public Content(int id, String title, String description, Status status, Member assignee, Priority priority) {
        super(id, title, description, status);
        this.assignee = assignee;
        this.priority = priority;
    }


    public Member getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }
}
