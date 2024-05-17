package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.Severity;

import java.util.List;

public interface Bug extends Task {


    Severity getSeverity();

    void addStep(String step);

    void advanceSeverity();
    void revertSeverity();
}
