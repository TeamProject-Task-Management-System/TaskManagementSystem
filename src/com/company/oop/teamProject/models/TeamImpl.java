package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.Board;
import com.company.oop.teamProject.models.contracts.Team;
import com.company.oop.teamProject.utils.ValidationHelper;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Team {
    public static final int TEAM_NAME_MIN_LENGTH = 5;
    public static final int TEAM_NAME_MAX_LENGTH = 15;
    public static final String TEAM_NAME_ERR_MESSAGE = "Team name must be between 5 and 15";

    private String name;

    public TeamImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        ValidationHelper.validateIntRange(name.length(), TEAM_NAME_MIN_LENGTH,
                TEAM_NAME_MAX_LENGTH, TEAM_NAME_ERR_MESSAGE);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
