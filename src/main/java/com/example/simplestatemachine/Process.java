package com.example.simplestatemachine;

import java.util.HashMap;
import java.util.Map;

public class Process {
    private Map<StateTransition, ProcessState> transitions;
    private ProcessState currentState;

    public Process() {
        currentState = ProcessState.Inactive;

        transitions = new HashMap<>();
        transitions.put(new StateTransition(ProcessState.Inactive, Command.Begin), ProcessState.Active);
        transitions.put(new StateTransition(ProcessState.Inactive, Command.Exit), ProcessState.Terminated);
        transitions.put(new StateTransition(ProcessState.Active, Command.Pause), ProcessState.Paused);
        transitions.put(new StateTransition(ProcessState.Active, Command.End), ProcessState.Inactive);
        transitions.put(new StateTransition(ProcessState.Paused, Command.Resume), ProcessState.Active);
        transitions.put(new StateTransition(ProcessState.Paused, Command.End), ProcessState.Inactive);
    }

    public ProcessState getCurrentState() {
        return currentState;
    }

    public ProcessState getNext(Command command) {
        StateTransition transition = new StateTransition(currentState, command);
        ProcessState nextState = transitions.get(transition);

        if (nextState == null) {
            throw new RuntimeException("Invalid action.");
        }

        return nextState;
    }

    public ProcessState moveNext(Command command) {
        currentState = getNext(command);
        return currentState;
    }
}
