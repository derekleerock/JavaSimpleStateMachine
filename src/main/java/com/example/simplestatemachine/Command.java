package com.example.simplestatemachine;

enum Command {
    Begin("begin"),
    End("end"),
    Pause("pause"),
    Resume("resume"),
    Exit("exit");

    private String commandCode;

    Command(String commandCode) {
        this.commandCode = commandCode;
    }

    @Override
    public String toString() {
        return commandCode;
    }
}
