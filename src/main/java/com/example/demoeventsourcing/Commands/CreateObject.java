package com.example.demoeventsourcing.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateObject {

    @TargetAggregateIdentifier
    private String commandId;
    private String message;

    public CreateObject(String commandId, String message) {
        this.commandId = commandId;
        this.message = message;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
