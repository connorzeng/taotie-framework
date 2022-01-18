package com.connor.jdk.algorithm;

public class TestClass {

    /**
     * C->B->A
     * <p>
     * A->B->C
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        new Thread(() -> printer.print(), "C").start();
        new Thread(() -> printer.print(), "B").start();
        new Thread(() -> printer.print(), "A").start();
    }
}

class Printer {

    private volatile int count = 0;

    public void print() {

        // 当前线程的顺序
        int curThreadMod = Thread.currentThread().getName().charAt(0) - 'A';
        // 无锁驱动
        while (count < 3) {
            if (count % 3 == curThreadMod) {
                if (count >= 3) {
                    break;
                }
                System.out.println(Thread.currentThread().getName());
                count++;
            }
        }
    }
}
