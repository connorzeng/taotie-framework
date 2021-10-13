package com.connor.jdk.algorithm;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 一. 队列实现栈.(a.单队列实现,b.双队列实现,c.双端队列实现)
 * 二. 最小栈.(a.双栈实现,b.存放差值)
 */
public class StackDemo {

    public static void main(String[] args) {

        //1.queue to stack
        Mystack<Integer> mystack = new Mystack<>();
        //3 2 1
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);


        //弹出
        System.out.println(mystack.peek());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());

        //2.最小栈
        System.out.println("----------min push---------------");
        MinStatck minStatck = new MinStatck();
        minStatck.push(2);
        System.out.println(minStatck.getMin());
        minStatck.push(3);
        System.out.println(minStatck.getMin());
        minStatck.push(1);
        System.out.println(minStatck.getMin());

        System.out.println("----------min pop---------------");
        System.out.println("pop:"+minStatck.pop());
        System.out.println(minStatck.getMin());
        System.out.println("pop:"+minStatck.pop());
        System.out.println(minStatck.getMin());
        System.out.println("pop:"+minStatck.pop());
        System.out.println(minStatck.getMin());
    }
}

class Mystack<T> {


    //使用一个队列来执行
    public T value;
    private ArrayDeque<T> arrayDeque = new ArrayDeque<>();

    public boolean isEmpty() {
        return arrayDeque.isEmpty();
    }

    //压栈
    public void push(T t) {
        // 判断长度
        if (arrayDeque.size() == 0) {
            arrayDeque.offer(t);
            return;
        }
        // 每一次都要移动
        int moveSize = arrayDeque.size();
        arrayDeque.offer(t);
        for (int i = 0; i < moveSize; i++) {
            T poll = arrayDeque.poll();
            arrayDeque.offer(poll);
        }
    }

    //弹出
    public T pop() {
        return arrayDeque.poll();
    }

    //peek
    public T peek() {
        return arrayDeque.peek();
    }
}

class MinStatck {

    //正常压入:3->2->1
    //最小值:  1  1  1  0
    //差值栈:  2->1->1

    //正常压入:1->2->3
    //最小值:  1  2  3  0
    //差值栈: -1->-1->0

    //正常压入:1->3->2
    //最小值:  1  2  2 0
    //差值栈: -1->1->2

    //正常压入:2->1->3
    //最小值:  1  1  3  0
    //差值栈:  1->-2->3

    private int min = 0;

    private Stack<Integer> stack = new Stack<>();

    //操作O(1), 空间负载O(1)
    public int getMin() {
        return min;
    }

    /**
     * 压栈
     *
     * @return
     */
    public int push(int value) {

        if (stack.empty()) {
            min = value;
            stack.push(0);
            return value;
        }


        stack.push(value - min);
        if (value < min) {
            min = value;
        }
        return value;
    }

    public int pop() {

        //判断min是否改变
        Integer pop = stack.pop();
        if (pop < 0){
            int value = min;
            min = min - pop;
            return value;
        } else {
            return min + pop;
        }
    }
}