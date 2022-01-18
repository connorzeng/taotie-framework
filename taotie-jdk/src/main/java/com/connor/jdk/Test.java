package com.connor.jdk;

import java.util.LinkedList;
import java.util.Queue;

public class Test {


    public static void main(String[] args) {
        int[] param = new int[]{1, 4, 2, 3};
        System.out.println(maxProfile(param));
        Node one = new Node(1);
        Node two = new Node(2);
        Node root = new Node(0, one, two);
        printNode(root);

        int revert = revert(1234);
        System.out.println(revert);

    }

    public static double getDistance(int begin,int end,double d){
        //距离
        double dis = (end - begin) * d * 3.14;
        return dis / 1000;
    }

    private static int revert(int n) {
        int m = 0;
        while (n > 0) {

            m = m * 10 + n % 10;
            n = n / 10;

        }
        return m;
    }

    public static int maxProfile(int[] param) {

        if (param == null || param.length <= 1) {
            return 0;
        }
        //顺序遍历,动态规划
        int maxProfile = 0;     //最大获利
        int minPrice = param[0];//记录历史上最小的点
        for (int index = 1; index < param.length; index++) {

            maxProfile = Math.max(maxProfile, param[index] - minPrice);

            minPrice = Math.min(minPrice, param[index]);
        }

        return maxProfile;
    }

    //层序遍历
    private static void printNode(Node root) {

        if (root == null) {
            return;
        }
        Queue<Queue<Node>> queues = new LinkedList<>();
        Queue<Node> rootQueues = new LinkedList<>();
        rootQueues.offer(root);
        queues.offer(rootQueues);

        while (queues.peek() != null) {
            Queue<Node> printQueue = queues.poll();
            Queue<Node> nextQueue = new LinkedList<>();
            while (printQueue.peek() != null) {
                Node node = printQueue.poll();
                System.out.print(node.getValue() + " ");//打印
                if (node.getLeft() != null) {
                    nextQueue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextQueue.offer(node.getRight());
                }
            }

            if (!nextQueue.isEmpty()) {
                queues.add(nextQueue);
            }
            System.out.println("");//换行
        }
    }


}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}