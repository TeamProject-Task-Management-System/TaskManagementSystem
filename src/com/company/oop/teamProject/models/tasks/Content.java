package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.tasks.contracts.Prioritizable;
import com.company.oop.teamProject.models.tasks.enums.Priority;

public abstract class Content extends TaskImpl implements Prioritizable {
    private final Priority priority;

    public Content(String title, String description, Priority priority) {
        super(title, description);
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
