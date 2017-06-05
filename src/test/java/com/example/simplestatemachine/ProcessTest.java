package com.example.simplestatemachine;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProcessTest {

    @Test
    public void test_happyPathProcessTransitions() throws Exception {
        Process process = new Process();

        ProcessState currentState = process.getCurrentState();
        assertThat(currentState, equalTo(ProcessState.Inactive));
        System.out.println("Create Process: Current State = " + currentState);

        currentState = process.moveNext(Command.Begin);
        assertThat(currentState, equalTo(ProcessState.Active));
        System.out.println(" Command.Begin: Current State = " + currentState);

        currentState = process.moveNext(Command.Pause);
        assertThat(currentState, equalTo(ProcessState.Paused));
        System.out.println(" Command.Pause: Current State = " + currentState);

        currentState = process.moveNext(Command.End);
        assertThat(currentState, equalTo(ProcessState.Inactive));
        System.out.println("   Command.End: Current State = " + currentState);

        currentState = process.moveNext(Command.Exit);
        assertThat(currentState, equalTo(ProcessState.Terminated));
        System.out.println("  Command.Exit: Current State = " + currentState);
    }

    @Test(expected = RuntimeException.class)
    public void test_processThrowsException_whenMovingToInvalidState() throws Exception {
        Process process = new Process();


        process.moveNext(Command.Pause);
    }

}