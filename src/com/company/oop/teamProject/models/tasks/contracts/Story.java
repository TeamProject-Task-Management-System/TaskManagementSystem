package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.Size;

public interface Story extends Task {

    Size getSize();

    void advanceSize();
    void revertSize();
}
