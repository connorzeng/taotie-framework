package com.connor.agent;

import com.connor.agent.transformer.MyTransformer;

import java.lang.instrument.Instrumentation;

/**
 * 这是一个java agent
 */
public class TestAgent {

    public static void premain(String agentArgs, Instrumentation inst){
        System.out.println("TestAgent.premain");
        System.out.println(agentArgs);
        inst.addTransformer(new MyTransformer());
    }
}
