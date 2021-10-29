package com.connor.jdk.juc.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 1. sleep, wait可以响应interrupted, 通过打断, join其实也是wait,也可以被中断
// 2. 运行中的线程,通过标志位打断.(跑批线程)
// 3. 通过Runtime.getRuntime().addShutdownHook(t);
// 4. synchronied等待队列中的线程不可以打断.同理Reentralock.lock也不能打断线程
// 5. Reentralock有一个acquireInterruptibly 可以进行终端
public class TestInterrupted {


    public static void main(String[] args)  {

        // 获取线程句柄打断线程
        TestInterrupted testInterrutp = new TestInterrupted();
        Thread thread = testInterrutp.runThread();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();


        // 标记位
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(200),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{

            while(true){
                // 对于这种一直在工作的线程,必须使用标志位才能打断程序
                System.out.println("hello1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPoolExecutor.shutdown();
        //threadPoolExecutor.shutdownNow();

        // 注册shutdownhook回调函数
        Thread t = new Thread(()->{
            threadPoolExecutor.shutdown();
        });
        //这个是响应中断信号的,main函数的自然结束,不会响应
        Runtime.getRuntime().addShutdownHook(t);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }


    public Thread runThread(){
        Thread thread = new Thread(()->{
            while (true){
                // 一直疯跑的线程不会响应中断
                System.out.println("hello");
                synchronized (TestInterrupted.class){
                    System.out.println("获取锁");
                    try {
                        TestInterrupted.class.wait();//必须是锁谁,谁来wait
                    } catch (InterruptedException e) {
                        System.out.println("保存现场");
                        e.printStackTrace();
                        break;//需要添加break才能终止线程
                    }
                }
            }
        });
        thread.start();
        return thread;
    }
}
