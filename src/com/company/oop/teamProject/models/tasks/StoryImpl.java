package com.company.oop.teamProject.models.tasks;

import com.company.oop.teamProject.models.TaskImpl;
import com.company.oop.teamProject.models.contracts.Member;
import com.company.oop.teamProject.models.tasks.contracts.Assignable;
import com.company.oop.teamProject.models.tasks.contracts.Story;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.models.tasks.enums.Priority;
import com.company.oop.teamProject.models.tasks.enums.Size;
import com.company.oop.teamProject.utils.ValidationHelper;

public class StoryImpl extends TaskImpl implements Story, Assignable {

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
    public Priority getStoryPriority() {
        return priority;
    }

    public EnumsForStoryStatus getStoryStatus() {
        return status;
    }

    @Override
    public String getAsString() {
        return """
                Story ID: %d %s
                Description:
                %s
                Size: %s
                Priority: %s
                Status: %s
                """.formatted(id, getTitle(), getDescription(), size, priority, status);
    }
}
