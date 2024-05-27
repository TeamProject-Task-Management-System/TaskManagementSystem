package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Assignable;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;


public class BugImpl extends TaskImpl implements Bug, Assignable {

    private int id;
    private Severity severity;
    private Priority priority;
    private final List<String> steps = new ArrayList<>();
    private EnumsForBugStatus status;
    private Member assignee;

    public BugImpl(int id, String title, String description, Priority priority, Severity severity) {
        super(title, description);
        this.id = id;
        this.status = EnumsForBugStatus.ACTIVE;
        this.severity = severity;
        this.priority = priority;
        setAssignee(assignee);
    }

    @Override
    public void changeBugStatus(EnumsForBugStatus newStatus) {
        if (newStatus == this.status) {
            throw new IllegalArgumentException(String.format("Bug status is already %s", status));
        }
        EnumsForBugStatus previousStatus = this.status;
        this.status = newStatus;
        createNewEvent(String.format("Bug status changed from %s to %s", previousStatus, status));
    }

    @Override
    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    @Override
    public int getId() {
        return id;
    }

    public List<String> getSteps() {
        return new ArrayList<>(steps);
    }

    @Override
    public void changeSeverity(Severity newSeverity) {
        if (newSeverity == this.severity) {
            throw new IllegalArgumentException(String.format("Severity is already %s", severity));
        }
        Severity previousSeverity = this.severity;
        this.severity = newSeverity;
        createNewEvent(String.format("Bug's severity changed from %s to %s", previousSeverity, severity));
    }

    @Override
    public void changePriority(Priority priority) {
        if (priority == this.priority){
            throw new IllegalArgumentException(String.format("Priority is already %s", priority));
        }
        Priority previousPriority = this.priority;
        this.priority = priority;
        createNewEvent(String.format("Bug's priority changed from %s to %s", previousPriority, priority));
    }


    @Override
    public Severity getSeverity() {
        return severity;
    }

    @Override
    public void addStep(String step) {
        steps.add(step);
    }

    @Override
    public Member getAssignee() {
        return assignee;
    }

    public EnumsForBugStatus getBugStatus() {
        return status;
    }

    @Override
    public Priority getBugPriority() {
        return priority;
    }

    @Override
    public String getAsString() {
        return """
                Bug ID: %d %s
                Description:
                %s
                Assignee: %s
                Severity: %s
                Priority: %s
                Status: %s
                """.formatted(id, getTitle(), getDescription(), assignee.getName(), severity, priority, status);
    }
}
