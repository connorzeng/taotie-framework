package com.connor.jdk.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThread {

    //C-B-A 三个线程顺序启动
    //顺序打印A-B-C
    public static void main(String[] args) {
        LinkedBlockingDeque a = new LinkedBlockingDeque();
        Printer printer = new Printer();
        new Thread(() -> {
            printer.print(2);
        }, "C").start();

        new Thread(() -> {
            printer.print(1);
        }, "B").start();

        new Thread(() -> {
            printer.print(0);
        }, "A").start();
    }

}
class Printer{
    Lock lock = new ReentrantLock();
    Map<String, Condition> conditionMap = new HashMap();
    Map<String, String> printMap = new HashMap();
    Map<String, String> nextMap = new HashMap();
    private int state;

    public Printer() {
        conditionMap.put("A", lock.newCondition());
        conditionMap.put("B", lock.newCondition());
        conditionMap.put("C", lock.newCondition());
        nextMap.put("A","B");
        nextMap.put("B","C");
        nextMap.put("C","A");
    }

    public void print(int trigeState){
        try {
            lock.lock();
            while (state % 3 != trigeState) {
                await();
            }
            state++;
            signalNext();
            System.out.println(Thread.currentThread().getName());
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
