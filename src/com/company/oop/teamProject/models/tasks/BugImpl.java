package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Severity;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.ArrayList;
import java.util.List;


public class BugImpl extends Content implements Bug {
    public static final int TILE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final String TITLE_ERR_MESSAGE = "Title name must be between 10 and 100";

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERR_MESSAGE = "Description name must be between 10 and 500";

    private Severity severity;
    private final List<String> steps = new ArrayList<>();

    public BugImpl(int id, String title, String description, Status status, Member assignee, Priority priority) {
        super(id, title, description, status, assignee, priority);
    }


    @Override
    protected void validateTitle(String title) {
        ValidationHelper.validateIntRange(title.length(),
                TILE_MIN_LENGTH,
                TITLE_MAX_LENGTH,
                TITLE_ERR_MESSAGE);
    }

    @Override
    protected void validateDescription(String description) {
        ValidationHelper.validateIntRange(description.length(),
                DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH,
                DESCRIPTION_ERR_MESSAGE);
    }

    @Override
    public void advanceStatus() {
        Status previousStatus = this.status;
        switch (this.status){
            case NOT_DONE:
                this.status = Status.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                this.status = Status.DONE;
                break;
            case DONE:
                createNewEvent(String.format("Can't advance, Bug status already at %s", status));
                break;
        }
        if (!previousStatus.equals(Status.DONE) && !status.equals(Status.DONE)) {
            createNewEvent(String.format("Bug status changed from %s to %s", previousStatus, status));
        }
    }

    @Override
    public void revertStatus() {
        Status previousStatus = this.status;
        switch (this.status){
            case NOT_DONE:
                createNewEvent(String.format("Can't revert, Bug status already at %s", status));
                break;
            case IN_PROGRESS:
                this.status = Status.NOT_DONE;
                break;
            case DONE:
                this.status = Status.IN_PROGRESS;
                break;
        }
        if (!previousStatus.equals(Status.NOT_DONE)) {
            createNewEvent(String.format("Bug status changed from %s to %s", previousStatus, status));
        }
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
    public void advanceSeverity() {
        Severity previousSeverity = this.severity;
        switch (this.severity){
            case MINOR:
                this.severity = Severity.MAJOR;
                break;
            case MAJOR:
                this.severity = Severity.CRITICAL;
                break;
            case CRITICAL:
                createNewEvent(String.format("Can't advance, already at %s", severity));
                break;
        }
        if (!previousSeverity.equals(Severity.CRITICAL) && !severity.equals(Severity.CRITICAL)) {
            createNewEvent(String.format("Severity changed from %s to %s", previousSeverity, severity));
        }
    }

    @Override
    public void revertSeverity() {
        Severity previousSeverity = this.severity;
        switch (this.severity){
            case MINOR:
                createNewEvent(String.format("Can't revert, already at %s", severity));
                break;
            case MAJOR:
                this.severity = Severity.MINOR;
                break;
            case CRITICAL:
                this.severity = Severity.MAJOR;
                break;
        }
        if (!previousSeverity.equals(Severity.MINOR)) {
            createNewEvent(String.format("Severity changed from %s to %s", previousSeverity, severity));
        }
    }
}
