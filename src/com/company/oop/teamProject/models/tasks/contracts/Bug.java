package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.EnumsForBugStatus;
import com.company.oop.teamProject.models.tasks.enums.Severity;

public interface Bug extends Task {


    Severity getSeverity();

    void addStep(String step);

    void changeSeverity(Severity newSeverity);

    void changeBugStatus(EnumsForBugStatus newStatus);
}
