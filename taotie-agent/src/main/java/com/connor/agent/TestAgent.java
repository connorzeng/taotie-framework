package com.connor.agent;

import java.lang.instrument.Instrumentation;

/**
 * 这是一个java agent
 */
public class TestAgent {

    public static void premain(String agentArgs, Instrumentation inst){
        System.out.println("TestAgent.premain");

        System.out.println(agentArgs);
    }
}
