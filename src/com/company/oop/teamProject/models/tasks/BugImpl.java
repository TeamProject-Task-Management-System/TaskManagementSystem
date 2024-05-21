package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Bug;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
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

    private int id;
    private Severity severity;
    private final List<String> steps = new ArrayList<>();
    private EnumsForBugStatus status;
    private List<Bug> bugs;

    public BugImpl(int id, String title, String description, Priority priority, Severity severity) {
        super(title, description, priority);
        this.id = id;
        this.status = EnumsForBugStatus.ACTIVE;
        this.severity = severity;
        this.bugs = new ArrayList<>();
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
    public void changeBugStatus(EnumsForBugStatus newStatus) {
        if (newStatus == this.status) {
            throw new IllegalArgumentException(String.format("Bug status is already %s", status));
        }
        EnumsForBugStatus previousStatus = this.status;
        this.status = newStatus;
        createNewEvent(String.format("Bug status changed from %s to %s", previousStatus, status));
    }

    public List<Bug> getBugs() {
        return new ArrayList<>(bugs);
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
        createNewEvent(String.format("Severity status changed from %s to %s", previousSeverity, severity));
    }

    @Override
    public Severity getSeverity() {
        return severity;
    }

    @Override
    public void addStep(String step) {
        steps.add(step);
    }
}
