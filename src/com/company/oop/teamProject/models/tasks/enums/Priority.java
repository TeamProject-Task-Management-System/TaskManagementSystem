package com.company.oop.teamProject.models.tasks.enums;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public String toString() {
        switch (this) {
            case LOW:
                return "Low";
            case MEDIUM:
                return "Medium";
            case HIGH:
                return "High";
            default:
                throw new IllegalArgumentException();
        }
    }
}
