package com.connor.jdk.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrierDemo {

    // 静态内部类只能引用static变量.
    // 非静态内部类可以引用所有的外部类变量.
    private static String name = "整个";


    public static void main(String[] args) {

        // 相较与join,CountDownLatch,
        // CyclicBarrier不会阻塞主线程.
        // 基于ReentraLoak, lock condition 唤醒机制.
        // 最后一个party执行完毕, cout==0,执行Runnable.run, 然后唤醒其他线程, 在调用nextGeneration进行重制cout
        // CyclicBarrier 可以理解为: 加法计数器;
        // CountDownLatch 可以理解为: 减法计数器;


        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++)
            new Writer(barrier).start();


        System.out.println("hello");
    }


    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            //System.out.println(name);
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }


    class Hello extends Thread{
        @Override
        public void run() {
            System.out.println(name);
        }
    }

}
