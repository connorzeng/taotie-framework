package com.connor.jdk.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeProductorDemoC {

    public static void main(String[] args) {

        DataC data = new DataC();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.decrement();
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.decrement();
            }
        }, "D").start();
    }


}

class DataC {

    private volatile int i = 0;
    Lock lock = new ReentrantLock();
    Map<String, Condition> conditionMap = new HashMap();
    Map<String, String> nextMap = new HashMap();

    public DataC() {
        conditionMap.put("A", lock.newCondition());
        conditionMap.put("B", lock.newCondition());
        conditionMap.put("C", lock.newCondition());
        conditionMap.put("D", lock.newCondition());
        nextMap.put("A","B");
        nextMap.put("B","C");
        nextMap.put("C","D");
        nextMap.put("D","A");
    }

    // 等待唤醒必须要加synchronized
    public void increment() {

        try {
            lock.lock();
            //if (i > 0){ //使用if会造成虚假唤醒
            while (i > 0) {
                await();
            }
            i++;
            signalNext();
            System.out.println(Thread.currentThread().getName() + "->" + i);
        } finally {
            lock.unlock();
        }
    }



    // 等待唤醒必须要加synchronized
    public void decrement() {
        try {
            lock.lock();
            //if (i > 0){ //使用if会造成虚假唤醒
            while (i == 0) {
                await();
            }
            i--;
            signalNext();
            System.out.println(Thread.currentThread().getName() + "->" + i);
        } finally {
            lock.unlock();
        }
    }

    private void await() {
        // 判断当前线程
        try {
            conditionMap.get(Thread.currentThread().getName()).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void signalNext() {

        conditionMap.get(nextMap.get(Thread.currentThread().getName())).signal();

    }



}


