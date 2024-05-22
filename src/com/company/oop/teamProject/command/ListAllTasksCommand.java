package com.company.oop.teamProject.command;

import com.company.oop.teamProject.core.contracts.TaskManagementRepository;
import com.company.oop.teamProject.models.contracts.Task;
import com.company.oop.teamProject.utils.ListingHelper;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.util.List;
import java.util.stream.Collectors;

public class ListAllTasksCommand extends BaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final List<Task> tasks;

    public ListAllTasksCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        tasks = getTaskManagementRepository().getTasks();
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);

        return ListingHelper.elementsToString(filterNeeded(tasks, name));
    }

    private List<Task> filterNeeded(List<Task> tasks, String name) {
        return tasks
                .stream()
                .filter(task -> task.getTitle().contains(name))
                .sorted()
                .collect(Collectors.toList());
    }
}
