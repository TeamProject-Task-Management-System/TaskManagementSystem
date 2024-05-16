package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.Severity;

import java.util.List;

public interface Bug extends Task {

    List<String> steps();

    Severity getSeverity();

    void addStep();

    void advanceSeverity(Severity severity);
    void revertSeverity(Severity severity);
}
