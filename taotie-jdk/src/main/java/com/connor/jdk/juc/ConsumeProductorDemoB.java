package com.connor.jdk.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeProductorDemoB {

    public static void main(String[] args) {

        DataB data = new DataB();

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
        }, "c").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.decrement();
            }
        }, "d").start();
    }


}

class DataB {

    private volatile int i = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    // 等待唤醒必须要加synchronized
    public void increment() {

        try {
            lock.lock();
            //if (i > 0){ //使用if会造成虚假唤醒
            while (i > 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            condition.signalAll();
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
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i--;
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + "->" + i);
        } finally {
            lock.unlock();
        }
    }

}


