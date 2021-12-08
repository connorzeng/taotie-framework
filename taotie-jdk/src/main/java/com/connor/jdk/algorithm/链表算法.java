package com.connor.jdk.algorithm;

public class 链表算法 {


    public static void main(String[] args) {
        //1->2->3->4->5->6->7->8
        NodeOneway header = new NodeOneway("1");
        header.buildNext(new NodeOneway("2"))
                .buildNext(new NodeOneway("3"))
                .buildNext(new NodeOneway("4"))
                .buildNext(new NodeOneway("5"))
                .buildNext(new NodeOneway("6"))
                .buildNext(new NodeOneway("7"))
                .buildNext(new NodeOneway("8"))
                .buildNext(new NodeOneway("9"))
                .buildNext(new NodeOneway("0"))
                .buildNext(new NodeOneway("1"));
        header.print();

        NodeOneway nodeOneway = revertListGroup(header, 3);
        nodeOneway.print();
        //revertPerK(header, 3);
        //header.print();
    }

    private static void revertPerK(NodeOneway header, int i) {

        if (i <= 0) {
            return;
        }
        //1. 反转一次
        NodeOneway revertFirst = revertList(header);
        revertFirst.print();

        //2. 按K值反转一次
        NodeOneway nodeOneway = revertListGroup(revertFirst, i);
        nodeOneway.print();


        //3. 在反转一次

    }

    /**
     * 这里需要
     *
     * @param revertFirst
     * @param i
     * @return
     */
    private static NodeOneway revertListGroup(NodeOneway revertFirst, int i) {

        if (revertFirst == null) {
            return null;
        }
        int length = 1;
        NodeOneway head = revertFirst;
        while (head.getNext() != null) {
            length++;
            head = head.getNext();
        }
        if (length < i) {
            return revertFirst;
        }

        //1 2 3 4 5 6 7 8
        //3 2 1     4 5 6   7 8
        //3 2 1     6 5 4   7 8
        //一个指针记录pos
        int pos = 1;
        NodeOneway next = revertFirst.getNext();
        NodeOneway current = revertFirst;
        NodeOneway headerOrg = revertFirst;//1 要指向 4
        // 直接计数进行反转
        while (pos < i) {

            NodeOneway farNext = next.getNext();
            next.setNext(current);

            current = next;
            next = farNext;
            pos++;
        }

        headerOrg.setNext(revertListGroup(next, i));
        return current;
    }


    private static NodeOneway revertList(NodeOneway header) {

        if (header == null || header.getNext() == null) {
            return header;
        }

        NodeOneway current = header;
        NodeOneway next = header.getNext();
        current.setNext(null);

        while (next.getNext() != null) {

            NodeOneway pioneer = next.getNext();
            next.setNext(current);

            current = next;
            next = pioneer;
        }
        next.setNext(current);

        return next;
    }

    //链表分组反装
    //例如： 链表:1->2->3->4->5->6->7->8->null, K = 3。
    // 那么 6->7->8，3->4->5，1->2各位一组。调整后：1->2->5->4->3->8->7->6->null。
    // 其中 1，2不调整，因为不够一组。

}

class NodeOneway {

    private NodeOneway next;

    private String value;


    public NodeOneway(String value) {
        this.value = value;
    }

    public NodeOneway getNext() {
        return next;
    }

    public void setNext(NodeOneway next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeOneway buildNext(NodeOneway nodeOneway) {
        setNext(nodeOneway);
        return nodeOneway;
    }

    public void print() {
        System.out.println(value);
        NodeOneway index = next;
        while (index != null) {
            System.out.println(index.value);
            index = index.next;
        }
    }
}
