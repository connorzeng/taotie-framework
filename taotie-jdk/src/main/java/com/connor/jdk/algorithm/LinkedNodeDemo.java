package com.connor.jdk.algorithm;

import com.connor.jdk.dto.NodeOneWay;

public class LinkedNodeDemo {

    private static NodeOneWay<Integer> crossNode = new NodeOneWay<>(6);

    private static NodeOneWay<Integer> cirlceNode = new NodeOneWay<>(6);

    public static void main(String[] args) {

        //相交单链表Test
        judgeLinkedNodeCrossTest();

        //环链表Test
        judgeLinkedNodeCircleTest();

        //反转链表
        linkedNodeReverseTest();

        //合并两个有序链表
        mergerTwoSortedLinkedList();

        //链表中倒数第K个节点.
        findReverKNode();


        //输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        //输出：7 -> 8 -> 0 -> 7
        //链表相加.


        //int.class
        Class<? extends Class> aClass = int.class.getClass();
        System.out.println(aClass.getName());
        // 会自动装箱为Integer
        int a = 1;
        Object b = (Object) a;
        System.out.println(b.getClass());
    }

    private static void findReverKNode() {

        NodeOneWay<Integer> a = buildNormal();


        //找到倒数第4个节点.
        //双指针法.
        int k = 4;

        NodeOneWay<Integer> firstP = a;
        NodeOneWay<Integer> secP = a;
        for (int i = 0; i < k; i++) {
            firstP = firstP.getNext();
        }

        while (firstP != null) {
            if (firstP.getNext() == null){
                System.out.println("倒数第"+k+"个节点:" + secP.getVaule());
                break;
            }

            firstP = firstP.getNext();
            secP = secP.getNext();
        }
    }

    private static void mergerTwoSortedLinkedList() {


        NodeOneWay<Integer> a = buildNormal();
        NodeOneWay<Integer> b = buildNormal();
        b.addTail(new NodeOneWay(12));
        b.addTail(new NodeOneWay(12));
        b.addTail(new NodeOneWay(13));

        NodeOneWay<Integer> mergeNode = null;
        NodeOneWay<Integer> aPoint = a;
        NodeOneWay<Integer> bPoint = b;

        while (aPoint != null || bPoint != null) {
            boolean breakFlag = false;
            NodeOneWay<Integer> smallTempOne = null;
            if (aPoint != null && bPoint != null) {
                if (aPoint.getVaule() < bPoint.getVaule()) {
                    smallTempOne = new NodeOneWay(aPoint.getVaule());
                    //a指针移动一下
                    aPoint = aPoint.getNext();
                } else {
                    smallTempOne = new NodeOneWay(bPoint.getVaule());
                    //b指针移动一下
                    bPoint = bPoint.getNext();
                }
            } else if (aPoint == null && bPoint != null) {
                smallTempOne = bPoint;
                breakFlag = true;
            } else {
                smallTempOne = aPoint;
                breakFlag = true;
            }


            if (mergeNode == null) {
                mergeNode = smallTempOne;
            } else {
                mergeNode.addTail(smallTempOne);
            }
            if (breakFlag) {
                break;
            }
        }
        System.out.println("------merger-----");
        mergeNode.printNodeAll();
    }

    private static void linkedNodeReverseTest() {

        //构建一个1->10链条
        NodeOneWay<Integer> a = buildNormal();
        System.out.println("1->10链表");
        a.printNodeAll();


        //使用迭代器反转
        NodeOneWay<Integer> reverseA = reverseNode(a);
        System.out.println("10->1链表");
        reverseA.printNodeAll();


        //三指针反转法.1. pre, current, next
        System.out.println("10->1链表-ThreePoint");
        a = buildNormal();
        NodeOneWay<Integer> reverseB = reverseNodeThreePoint(a);
        reverseB.printNodeAll();

    }

    private static NodeOneWay<Integer> reverseNodeThreePoint(NodeOneWay<Integer> a) {

        NodeOneWay pre = null;
        NodeOneWay current = a;
        NodeOneWay next = a.getNext();
        while (next != null) {

            NodeOneWay temp = current;//临时记录

            current.setNext(pre);//current next指针反转
            current = next;//current指针移动

            next = next.getNext();//next指针移动

            pre = temp;//pre指针移动
        }

        current.setNext(pre);

        return current;
    }

    private static NodeOneWay<Integer> reverseNode(NodeOneWay<Integer> a) {

        if (a.getNext() == null) {
            //返回head
            return new NodeOneWay<>((Integer) a.getVaule());
        } else {
            //取出来
            NodeOneWay<Integer> currentNode = new NodeOneWay<>((Integer) a.getVaule());
            NodeOneWay head = reverseNode(a.getNext());
            return head.addTail(currentNode);
        }
    }


    private static void judgeLinkedNodeCrossTest() {

        NodeOneWay<Integer> a = buildA();
        NodeOneWay<Integer> b = buildB();
        //a.printNodeAll();
        //b.printNodeAll();


        System.out.println(a.getTail() + ":" + a.getTail().hashCode() + ":" + a.getTail().getVaule());
        System.out.println(b.getTail() + ":" + b.getTail().hashCode() + ":" + b.getTail().getVaule());

        // 如果尾节点相等即为相交
        if (a.getTail().hashCode() == b.getTail().hashCode()) {
            System.out.println("a,b相交");
        }

        //TODO 链表相交计算相交节点算法.
        //判断相交节点,并且返回.
        //1. 使用等长length,同步比对法.//最好你的linked有记录legth(size)
        //2. 使用Hash值比对法.//遍历第一条链表时, 将每个参数加入Hash容器. 遍历第二条链表,从Hash容器中获取数据比对.第一个相同的即为相交
        //3. 使用栈的数据结构来进行
    }


    private static void judgeLinkedNodeCircleTest() {

        //构建一个环链
        NodeOneWay<Integer> head = buildCicle();
        //构建一个无环链
        //NodeOneWay<Integer> head = buildA();


        NodeOneWay point1 = head;
        NodeOneWay point2 = head;
        //1. 使用双指法
        int point1Index = 0;
        int point2Index = 0;
        for (; ; ) {
            point1Index++;
            point2Index += 2;
            point1 = point1.getNext();
            if (point1 == null) {
                System.out.println("没有环");
                break;
            }
            point2 = point2.getNext().getNext();
            if (point2 == null) {
                System.out.println("没有环");
                break;
            }
            if (point1.equals(point2)) {
                System.out.println("有环");
                System.out.println(point1Index);
                System.out.println(point2Index);
                break;
            }
        }
    }

    private static NodeOneWay<Integer> buildCicle() {

        NodeOneWay<Integer> head = new NodeOneWay<>(1);


        for (int i = 2; i <= 10; i++) {
            //System.out.println(i);
            if (i == 6) {
                //交叉节点
                head.addTail(cirlceNode);
            } else {
                head.addTail(new NodeOneWay(i));
            }
        }

        //尾节点闭环
        head.addTail(cirlceNode);

        //head.printNodeAll();//有环的链就是无限死循环了
        return head;
    }


    //1,2,3,4,5,6,7,8,9,10
    private static NodeOneWay<Integer> buildA() {

        NodeOneWay<Integer> head = new NodeOneWay<>(1);
        for (int i = 2; i <= 10; i++) {
            //System.out.println(i);
            if (i == 6) {
                //交叉节点
                head.addTail(crossNode);
            } else {
                head.addTail(new NodeOneWay(i));
            }
        }

        //head.printNodeAll();
        return head;
    }

    private static NodeOneWay<Integer> buildNormal() {
        NodeOneWay<Integer> head = new NodeOneWay<>(1);
        for (int i = 2; i <= 10; i++) {

            head.addTail(new NodeOneWay(i));

        }

        return head;
    }

    //1,2,3,4,5,6,7,8,9,10
    private static NodeOneWay<Integer> buildB() {
        NodeOneWay<Integer> head = new NodeOneWay<>(1);
        for (int i = 2; i <= 10; i++) {
            //System.out.println(i);
            if (i == 6) {
                //交叉节点
                head.addTail(crossNode);
            } else {
                head.addTail(new NodeOneWay(i));
            }
        }

        //head.printNodeAll();
        return head;
    }

}
