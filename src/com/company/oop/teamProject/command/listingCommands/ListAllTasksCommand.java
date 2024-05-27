package com.company.oop.teamProject.command.listingCommands;

import com.company.oop.teamProject.command.BaseCommand;
import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListAllTasksCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Task> tasks;

    public ListAllTasksCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        tasks = getTaskManagementRepository().getTasks();
    }

    @Override
    protected String executeCommand(List<String> parameters) {

        return ListingHelper.elementsToString(filterNeeded(tasks));
    }

    private List<Task> filterNeeded(List<Task> tasks) {
        return tasks
                .stream()
                .sorted(Comparator.comparing(task -> task.getTitle()))
                .collect(Collectors.toList());
    }
}
