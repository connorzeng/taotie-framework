package com.connor.jdk.juc.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestIntruptedLock {


    public static void main(String[] args) {

        Cooker2 cooker = new Cooker2();

        Thread t = new Thread(() -> {
            cooker.makeFood();
        });
        t.start();


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            cooker.makeFood();
        });
        t2.start();

        t2.interrupt();
        System.out.println(t2.isAlive());
        //t.interrupt();
        System.out.println(t.isAlive());
    }
}


class Cooker2 {
    private static ReentrantLock lock = new ReentrantLock();


    public void makeFood() {


        try {
            lock.lockInterruptibly();
            //lock.lock(); 这个同步队列不会响应终端


            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "我要保存现场,停止了");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


