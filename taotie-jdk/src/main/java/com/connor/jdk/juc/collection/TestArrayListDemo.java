package com.connor.jdk.juc.collection;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 测试集合类的安全.
 */
public class TestArrayListDemo {

    public static void main(String[] args) {
        testCurrent();
//        testArrayLink();

    }

    /**
     * 测试数组,链表
     */
    private static void testArrayLink() {

        long start = System.currentTimeMillis();//
//        List<String> list = new ArrayList<>();//108
        List<String> list = new LinkedList<>();//
        for (int i = 0; i < 1000000; i++) {
            list.add(i + "helloconnor");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 测试并发
     */
    private static void testCurrent() {


        // 1.并发修改异常 java.util.ConcurrentModificationException ( 使用Collections.synchronizedCollection无法解决 )
        //   只有CopyOnWriteArrayList能解决ConcurrentModificationException
        // 2.并发添加会造成数据被覆盖,丢数据.

        // ArrayList扩容  int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 只有当容量满了才会扩容,每次右移一位, 初始值为10   10+5   15+7
        // 通过modCount来判定是否被修改过.

//        Collection<String> list = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
//        Collection<String> list = new Vector<>();
//        Collection<String> list = Collections.synchronizedCollection(new ArrayList<>());
//        Collection<String> list = new CopyOnWriteArrayList();

        // 进行一个增加
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    list.add(finalI + "" + j + "");
                    //System.out.println(list);
                }
            }, i + "").start();

//            new Thread(()->{
//                Iterator<String> iterator = list.iterator();
//                while(iterator.hasNext()){
//                    String next = iterator.next();
//                }
//            }).start();
        }


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }


}
