package com.connor.jdk.algorithm;

import com.connor.jdk.algorithm.dto.NodeOneway;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class 链表倒数第K个节点 {

    public static void main(String[] args) {

        NodeOneway header = new NodeOneway("1");
        header.buildNext(new NodeOneway("2"))
                .buildNext(new NodeOneway("3"))
                .buildNext(new NodeOneway("4"))
                .buildNext(new NodeOneway("5"))
                .buildNext(new NodeOneway("6"))
                .buildNext(new NodeOneway("7"))
                .buildNext(new NodeOneway("8"))
                .buildNext(new NodeOneway("9"))
                .buildNext(new NodeOneway("0"));


        NodeOneway nodeOneway = findK(header, 2);

        System.out.println(nodeOneway.getValue());

    }

    private static NodeOneway findK(NodeOneway header, int k) {

        if (header == null || header.getNext() == null) {
            return header;
        }

        NodeOneway fast = header;//快指针先把K走完,然后同步向前走
        NodeOneway slow = header;

        while (fast.getNext() != null && k > 0) {
            fast = fast.getNext();
            k--;
        }

        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }
}
