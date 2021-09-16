package com.connor.jdk.juc.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountLatchDownDemo {


    // 测试
    public static void main(String[] args) throws InterruptedException {

        testCountDownLatch();
        // 测试join
        //testJoin();
    }

    private static void testCountDownLatch() throws InterruptedException {

        //基于AQS队列实现.
        //1. 设置锁的大小

        //新建latch锁.
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕");
            latch.countDown();
        }).start();

        latch.await();
    }

    private static void testJoin() throws InterruptedException {

        //CountDownLatch latch = new CountDownLatch(5);
        Thread a = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        // join 就是获取线程对象a的对象锁, 然后进入锁等待.
        // synchronized
        // 锁的唤醒是在JVM中, 线程执行完毕会由JVM进行notifyAll唤醒.
        a.join();


        System.out.println("hello");
    }


}
