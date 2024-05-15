package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.tasks.enums.Severity;

import java.util.List;

public interface Bug {

    List<String> steps();

    Severity getSeverity();

    void addStep();
}
