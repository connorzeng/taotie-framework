package com.connor.taotie.tool.delay;

import java.util.concurrent.DelayQueue;

public class JdkDelayManager extends AbstrackDelayManager{


    DelayQueue<Task> delayQueue = new DelayQueue<Task>();


    @Override
    protected void saveToDb(Task task) {

    }

    @Override
    protected void addDelayQueue(Task task) {

    }

    @Override
    public void pollDelayTask() {

    }
}
