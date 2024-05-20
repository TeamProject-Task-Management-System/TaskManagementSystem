package com.company.oop.teamProject.models.tasks.enums;

public enum EnumsForStoryStatus {
    NOT_DONE,
    IN_PROGRESS,
    DONE;

    public String toString() {
        switch (this) {
            case NOT_DONE:
                return "Not Done";
            case IN_PROGRESS:
                return "InProgress";
            case DONE:
                return "Done";
            default:
                throw new IllegalArgumentException();
        }
    }
}
