package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Assignable;
import com.company.oop.teamProject.models.tasks.contracts.Prioritizable;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ValidationHelper;

public class StoryImpl extends TaskImpl implements Story, Assignable, Prioritizable {
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 100;
    public static final String TITLE_ERR_MESSAGE = "Title must be between 10 and 100";

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERR_MESSAGE = "Description must be between 10 and 500";

    private int id;
    private Size size;
    private EnumsForStoryStatus status;
    private Priority priority;
    private Member assignee;

    public StoryImpl(int id, String title, String description, Priority priority, Size size) {
        super(title, description);
        this.id = id;
        this.status = EnumsForStoryStatus.NOT_DONE;
        this.size = size;
        this.priority = priority;
        setAssignee(assignee);
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
    public void changeStoryStatus(EnumsForStoryStatus newStatus) {
        if (newStatus == this.status) {
            throw new IllegalArgumentException(String.format("Story status is already %s", status));
        }
        EnumsForStoryStatus previousStatus = this.status;
        this.status = newStatus;
        createNewEvent(String.format("Story status changed from %s to %s", previousStatus, status));
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void changeSize(Size newSize) {
        if (newSize == this.size) {
            throw new IllegalArgumentException(String.format("Size is already %s", size));
        }
        Size previousSize = this.size;
        this.size = newSize;
        createNewEvent(String.format("Size status changed from %s to %s", previousSize, size));
    }

    @Override
    public void changePriority(Priority priority) {
        if (priority == this.priority){
            throw new IllegalArgumentException(String.format("Priority is already %s", priority));
        }
        Priority previousPriority = this.priority;
        this.priority = priority;
        createNewEvent(String.format("Story's priority changed from %s to %s", previousPriority, priority));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setAssignee(Member assignee) {
        this.assignee = assignee;
    }

    @Override
    public Member getAssignee() {
        return assignee;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public String getAsString() {
        return """
                Story ID: %d %s
                Description:
                %s
                Size: %s
                Priority: %s
                Status: %s""".formatted(id, getTitle(), getDescription(), size, priority, status);
    }
}
