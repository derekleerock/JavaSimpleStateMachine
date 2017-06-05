package com.example.simplestatemachine;

enum ProcessState {
    Inactive("inactive"),
    Active("active"),
    Paused("paused"),
    Terminated("terminated");

    private String stateCode;

    ProcessState(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return stateCode;
    }
}
