package com.company.oop.teamProject.models.enums;

public enum Status {
    ACTIVE,
    DONE,
    NOT_DONE,
    IN_PROGRESS,
    NEW,
    UNSCHEDULED,
    SCHEDULED;

    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active";
            case DONE:
                return "Done";
            case NOT_DONE:
                return "Not Done";
            case IN_PROGRESS:
                return "InProgress";
            case NEW:
                return "New";
            case UNSCHEDULED:
                return "Unscheduled";
            case SCHEDULED:
                return "Scheduled";
            default:
                throw new IllegalArgumentException();
        }
    }
}
