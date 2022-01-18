package com.connor.jdk.juc;


public class TaskThread extends Thread {

    /**
     * 循环总的次数
     */
    private static int total = 3;
    /**
     * 当前循环的次数
     */
    private static volatile int count = 0;
    Object lock = new Object();
    /**
     * 需要打印的名称
     */
    private String name;
    /**
     * 信号量，用于线程间通信
     */
    private int printFlag = 0;

    public TaskThread(String name, int printFlag) {
        this.name = name;
        this.printFlag = printFlag;
    }

    public static void main(String args[]) {

        Thread a = new TaskThread("A", 0);
        Thread b = new TaskThread("B", 1);
        Thread c = new TaskThread("C", 2);
        c.start();
        b.start();
        a.start();
    }

    public void run() {
        //当前循环
        while (count < total) {
            //当前count等于打印标签则打印
            if ((count % 3) == printFlag) {
                    if (count >= total) {
                        System.out.println(" breank ");
                        break;
                    }
                    System.out.println(name + " " + count);
                    count++;
            }
        }
    }

}