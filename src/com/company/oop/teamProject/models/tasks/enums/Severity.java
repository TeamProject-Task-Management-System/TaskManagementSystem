package com.company.oop.teamProject.models.tasks.enums;

public enum Severity {
    MINOR,
    MAJOR,
    CRITICAL;

    public String toString() {
        switch (this) {
            case MINOR:
                return "Minor";
            case MAJOR:
                return "Major";
            case CRITICAL:
                return "Critical";
            default:
                throw new IllegalArgumentException();
        }
    }
}
