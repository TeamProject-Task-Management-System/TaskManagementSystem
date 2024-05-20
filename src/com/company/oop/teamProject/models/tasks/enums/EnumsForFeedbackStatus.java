package com.company.oop.teamProject.models.tasks.enums;

public enum EnumsForFeedbackStatus {
    NEW,
    UNSCHEDULED,
    SCHEDULED,
    DONE;

    @Override
    public String toString() {
        switch (this) {
            case NEW:
                return "New";
            case UNSCHEDULED:
                return "Unscheduled";
            case SCHEDULED:
                return "Scheduled";
            case DONE:
                return "Done";
            default:
                throw new IllegalArgumentException();
        }
    }
}
