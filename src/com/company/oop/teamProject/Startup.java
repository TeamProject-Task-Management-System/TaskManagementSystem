package com.company.oop.teamProject;

import com.company.oop.teamProject.core.TaskManagementEngineImpl;

public class Startup {
    public static void main(String[] args) {
        TaskManagementEngineImpl engine = new TaskManagementEngineImpl();
        engine.start();
    }
}