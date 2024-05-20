package com.company.oop.teamProject.models.tasks.enums;

public enum EnumsForBugStatus {
    ACTIVE,
    DONE;

    public String toString() {
        switch (this) {
            case ACTIVE:
                return "Active";
            case DONE:
                return "Done";
            default:
                throw new IllegalArgumentException();
        }
    }
}
