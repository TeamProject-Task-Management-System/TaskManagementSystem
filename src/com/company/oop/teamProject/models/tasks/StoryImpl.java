package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
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

    private int id;
    private Size size;
    private EnumsForStoryStatus status;
    private Priority priority;

    public StoryImpl(int id, String title, String description, Priority priority, Size size) {
        super(title, description, priority);
        this.id = id;
        this.status = EnumsForStoryStatus.NOT_DONE;
        this.size = size;
        this.priority = priority;
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
}
