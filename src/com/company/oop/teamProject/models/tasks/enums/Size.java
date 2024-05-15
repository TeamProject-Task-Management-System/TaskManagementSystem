package com.company.oop.teamProject.models.tasks.enums;

public enum Size {
    SMALL,
    MEDIUM,
    LARGE;

    public String toString() {
        switch (this) {
            case SMALL:
                return "Small";
            case MEDIUM:
                return "Medium";
            case LARGE:
                return "Large";
            default:
                throw new IllegalArgumentException();
        }
    }
}
