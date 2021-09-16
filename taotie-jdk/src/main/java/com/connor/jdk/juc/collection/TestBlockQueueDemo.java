package com.connor.jdk.juc.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestBlockQueueDemo {


    // 阻塞队列就是基于ReentranLock Condition实现的一个生产者消费者.
//    /** Main lock guarding all access */
//    final ReentrantLock lock;
//    /** Condition for waiting takes */
//    private final Condition notEmpty;
//    /** Condition for waiting puts */
//    private final Condition notFull;

    public static void main(String[] args) {
//        test1();
//        test2();

        test3();

    }




    /**
     * 抛出异常
     */
    private static void test1()  {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        //hellos

        queue.add("1");
        queue.add("1");
        queue.add("1");
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        //queue.add("1");

        Object remove1 = queue.remove();
        Object remove2 = queue.remove();
        Object remove3 = queue.remove();
        // Exception in thread "main" java.util.NoSuchElementException
        //Object remove4 = queue.remove();
        queue.element();
    }

    /**
     * 不抛出异常
     */
    private static void test2() {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));
        // 不抛出错误, 返回false
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));



        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 不抛出错误, 返回null
        System.out.println(queue.poll());

        // 窥探,不会影响队列
        System.out.println(queue.peek());
    }


    /**
     * 阻塞等待.
     */
    private static void test3() {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        // 生产者
        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    queue.put("1");
                    System.out.println("生产put");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        // 生产者
        for (int i=0;i<10;i++){

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int finalI = i;
            new Thread(()->{

                // 支持批量消费
                if (finalI == 2){
                    ArrayList arrayList = new ArrayList();
                    queue.drainTo(arrayList,3);//批量消费3个
                    System.out.println(arrayList);
                }

                try {
                    queue.take();
                    System.out.println("生产take");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
