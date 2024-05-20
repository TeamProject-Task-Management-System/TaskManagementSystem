package com.company.oop.teamProject.models.tasks.contracts;

import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.models.tasks.enums.EnumsForStoryStatus;
import com.company.oop.teamProject.models.tasks.enums.Size;

public interface Story extends Task {

    Size getSize();

    void changeStoryStatus(EnumsForStoryStatus newStatus);

    void changeSize(Size newSize);
}
