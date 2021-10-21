package com.connor.jdk.jvm;

import com.connor.jdk.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOomDemo {

    public static void main(String[] args) {

        //heap区OOM
        //testHeapOOM();
        // a线程发生OOM, 不会影响导致B线程的运行, JVM没用崩溃.
        //testOneOOMOtherOK();


        // 静态常量JDK8中存放在heap区.
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //StaticFieldOOM bigStatic = new StaticFieldOOM();

        //
        StaticMethodOOM bigStatic = new StaticMethodOOM();

        //栈溢出
        //testA();
        
        
        //方法区溢出
        //需要设置MaxMataSpaceSize
        //不停的增强class



        //直接内存溢出
        //unsafe.allocateMeme...
    }

    private static void testA() {

        testA();

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
class StaticFieldOOM {

    //static是在heap区域上面
    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    static User[][] users1 = new User[4096][4096];
    static User[][] users2 = new User[4096][4096];
    static User[][] users3 = new User[4096][4096];
    static User[][] users4 = new User[4096][4096];
    static User[][] users5 = new User[4096][4096];
    static User[][] users6 = new User[4096][4096];

}

class StaticMethodOOM{

    public static String getIndexFromFooAndJustFine(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }
    public static String getIndexFromFooAndJustFine1(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }public static String getIndexFromFooAndJustFine2(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }public static String getIndexFromFooAndJustFine3(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }public static String getIndexFromFooAndJustFine4(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }public static String getIndexFromFooAndJustFine5(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }public static String getIndexFromFooAndJustFine6(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }
    public static String getIndexFromFooAndJustFine7(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }
    public static String getIndexFromFooAndJustFine8(){
        User[][] users6 = new User[4096][4096];
        return "hello,iamfile";
    }





}
