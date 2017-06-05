package com.example.simplestatemachine;

public class StateTransition {
    private ProcessState currentState;
    private Command command;

    StateTransition(ProcessState currentState, Command command) {
        this.currentState = currentState;
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateTransition that = (StateTransition) o;

        if (currentState != that.currentState) return false;
        return command == that.command;
    }

    @Override
    public int hashCode() {
        int result = currentState != null ? currentState.hashCode() : 0;
        result = 31 * result + (command != null ? command.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StateTransition{" +
                "currentState=" + currentState +
                ", command=" + command +
                '}';
    }
}
