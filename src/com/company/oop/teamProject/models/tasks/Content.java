package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Assignable;
import com.company.oop.teamProject.models.tasks.contracts.Prioritizable;
import com.company.oop.teamProject.models.tasks.enums.Priority;

public abstract class Content extends TaskImpl implements Assignable, Prioritizable {
    private final Member assignee;
    private final Priority priority;

    public Content(String title, String description, Member assignee, Priority priority) {
        super(title, description);
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
