package com.connor.jdk.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSaleDemo {


    public static void main(String[] args) {


        TicketSale ticketSale = new TicketSale();


        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                ticketSale.sellTick();
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                ticketSale.sellTick();
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                ticketSale.sellTick();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                ticketSale.sellTick();
            }
        }, "D").start();

    }


}

class TicketSale {

    //总的票数 100W
    private volatile int tickeNum = 1000000;
    long start = System.currentTimeMillis();

    // 使用synchronized 22227
    // 使用Lock  22701   cpu 33~40

    Lock lock = new ReentrantLock();


    public synchronized void sellTick() {
        //lock.lock();
        try {
            if (tickeNum > 0) {
                System.out.println("当前线程" + Thread.currentThread().getName() + "卖票," + "总计:" + tickeNum-- + " 剩余:" + tickeNum);
                if (tickeNum == 0) {
                    System.out.println(System.currentTimeMillis() - start);
                }
            }
        } finally {
            //lock.unlock();
        }
    }
}
