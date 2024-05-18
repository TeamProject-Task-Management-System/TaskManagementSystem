package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.enums.Status;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ValidationHelper;

public class StoryImpl extends Content implements Story {
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final String TITLE_ERR_MESSAGE = "Title must be between 10 and 100";

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERR_MESSAGE = "Description must be between 10 and 500";

    private Size size;

    public StoryImpl(int id, String title, String description, Status status, Member assignee, Priority priority, Size size) {
        super(id, title, description, status, assignee, priority);
        this.size = size;
    }

    @Override
    protected void validateTitle(String title) {
        ValidationHelper.validateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, TITLE_ERR_MESSAGE);
    }

    @Override
    protected void validateDescription(String description) {
        ValidationHelper.validateIntRange(description.length(), DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH, DESCRIPTION_ERR_MESSAGE);
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
                createNewEvent(String.format("Can't advance, Story status already at %s", status));
                break;
        }
        if (!previousStatus.equals(Status.DONE) && !status.equals(Status.DONE)) {
            createNewEvent(String.format("Story status changed from %s to %s", previousStatus, status));
        }
    }

    @Override
    public void revertStatus() {
        Status previousStatus = this.status;
        switch (this.status){
            case NOT_DONE:
                createNewEvent(String.format("Can't revert, Story status already at %s", status));
                break;
            case IN_PROGRESS:
                this.status = Status.NOT_DONE;
                break;
            case DONE:
                this.status = Status.IN_PROGRESS;
                break;
        }
        if (!previousStatus.equals(Status.NOT_DONE)) {
            createNewEvent(String.format("Story status changed from %s to %s", previousStatus, status));
        }
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void advanceSize() {
        Size previousSize = this.size;
        switch (this.size) {
            case SMALL:
                this.size = Size.MEDIUM;
                break;
            case MEDIUM:
                this.size = Size.LARGE;
                break;
            case LARGE:
                createNewEvent(String.format("Can't advance, already at %s", size));
                break;
        }
        if (!previousSize.equals(Size.LARGE) && !size.equals(Size.LARGE)) {
            createNewEvent(String.format("Size changed from %s to %s", previousSize, size));
        }
    }

    @Override
    public void revertSize() {
        Size previousSize = this.size;
        switch (this.size) {
            case SMALL:
                createNewEvent(String.format("Can't revert, already at %s", size));
                break;
            case MEDIUM:
                this.size = Size.SMALL;
                break;
            case LARGE:
                this.size = Size.MEDIUM;
                break;
        }
        if (!previousSize.equals(Size.SMALL)) {
            createNewEvent(String.format("Size changed from %s to %s", previousSize, size));
        }
    }
}
