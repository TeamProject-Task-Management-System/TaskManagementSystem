package com.company.oop.teamProject.models;

import com.company.oop.teamProject.models.contracts.EventLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventLogImpl implements EventLog {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
    private String description;
    private LocalDate timeStamp;

    public EventLogImpl(String description){
        setDescription(description);
        this.timeStamp = LocalDate.now();
    }

    @Override
    public String getDescription(){
        return String.format("[%s] %s", timeStamp.format(formatter), description);
    }


    public void setDescription(String description){
        if ( description.isEmpty()){
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
        this.timeStamp = LocalDate.now();
    }
}
