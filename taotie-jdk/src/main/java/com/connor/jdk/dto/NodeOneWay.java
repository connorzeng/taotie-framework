package com.connor.jdk.dto;

/**
 * 单向链表
 * 疑问: 在哪里初始化,设置,head?
 * --> 会根据不同的插入方式有所不同.
 * --> 头插法,尾插法
 * https://segmentfault.com/a/1190000021501440
 */
public class NodeOneWay<T> {

    private NodeOneWay next;

    private NodeOneWay head;

    private T value;

    public NodeOneWay(T value) {
        this.value = value;
    }

    /**
     * 插入的句柄每次都是head节点
     * 头插法: 数据结构类似栈
     *
     * @param nodeOneWay
     */
    public NodeOneWay addTail(NodeOneWay nodeOneWay) {

        // 首次插入,构建head节点
        if (head == null) {
            next = nodeOneWay;
            head = this;
            return head;
        }

        // 寻找节点指针
        NodeOneWay tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = nodeOneWay;

        return head;
    }


    public NodeOneWay addHead(NodeOneWay nodeOneWay) {

        if (head == null) {
            head = this;
            return head;
        }

        NodeOneWay temp = head;
        head = nodeOneWay;
        head.next = temp;

        return head;
    }


    public NodeOneWay getNext() {
        return next;
    }

    public void printNodeAll() {

        NodeOneWay iterateNode = head;
        if (iterateNode == null) {
            iterateNode = this;
        }
        while (iterateNode.next != null) {
            System.out.println(iterateNode.value);
            iterateNode = iterateNode.next;
        }
        System.out.println(iterateNode.value);
    }

    public NodeOneWay getTail() {

        NodeOneWay temp = head;
        if (temp == null) {
            temp = this;
        }

        NodeOneWay tail = this;
        while (temp.next != null) {
            tail = temp.next;
            temp = temp.next;
        }
        return tail;
    }

    public T getVaule() {

        return  value;
    }

    public void setNext(NodeOneWay next) {
        this.next = next;
    }
}
