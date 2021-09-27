package com.connor.jdk.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOomDemo {

    public static void main(String[] args) {

        //testHeapOOM();


        // a线程发生OOM, 不会影响导致B线程的运行, JVM没用崩溃.
        testOneOOMOtherOK();

    }

    private static void testOneOOMOtherOK() {


        new Thread(()->{
            try {
                List<byte[]> bytes = new ArrayList<>();
                while(true){
                    bytes.add(new byte[500 * 1024]);
                    //System.out.println("hello");
                }
            } catch (Error e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ok Thread");
            }
        },"B").start();

    }

    private static void testHeapOOM() {

        List<byte[]> bytes = new ArrayList<>();

        // Byte[] y = new Byte[Integer.MAX_VALUE];//  java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        // 此处 : java.lang.OutOfMemoryError: Java heap space
        try {
            while(true){
                bytes.add(new byte[500 * 1024]);
                System.out.println("hello");
            }
        } catch (Error e) {
            e.printStackTrace();
        }


        System.out.println("afterALL");
    }
}
