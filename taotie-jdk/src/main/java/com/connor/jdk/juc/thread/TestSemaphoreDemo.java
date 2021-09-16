package com.connor.jdk.juc.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphoreDemo {


    public static void main(String[] args) {

        Worker worker = new Worker();

        for (int i = 0; i < 8; i++) {
            final int temp = i;
            new Thread(() -> {
                worker.doWork();
            }, temp + "").start();
        }
    }


}

class Worker {

    /**
     * 总共8个位置
     */
    private Semaphore semaphore = new Semaphore(3);


    /**
     * 开始工作
     */
    public void doWork() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ": 开始工作");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": 释放锁");
            semaphore.release();
        }
    }


}
