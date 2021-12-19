package com.connor.jdk.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeTestDemo2 {


    /**
     * 构建树
     * 1
     * 2   3
     * 4 5  6 7
     *
     * @param args
     */
    public static void main(String[] args) {

        //构建一棵树.
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode secleft = new TreeNode(2);
        TreeNode secRight = new TreeNode(3);
        root.setLeft(secleft);
        root.setRight(secRight);
        secleft.setLeft(new TreeNode(4));
        secleft.setRight(new TreeNode(5));
        secRight.setLeft(new TreeNode(6));
        TreeNode treeNode = new TreeNode(7);
        treeNode.setRight(new TreeNode(8));
        secRight.setRight(treeNode);


        List<Integer> result = new LinkedList<>();
        int index = 0;
        Queue<Queue<TreeNode<Integer>>> temp = new LinkedList<>();
        Queue<TreeNode<Integer>> rootFloor = new LinkedList<>();
        rootFloor.add(root);
        temp.offer(rootFloor);


        while (temp.peek() != null) {

            Queue<TreeNode<Integer>> floor = temp.poll();
            result.add(floor.peek().getValue());

            Queue<TreeNode<Integer>> nextFloor = new LinkedList<>();
            while (floor.peek() != null) {
                TreeNode<Integer> node = floor.poll();
                if (node.getLeft() != null) {
                    nextFloor.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextFloor.add(node.getRight());
                }
            }
            if (!nextFloor.isEmpty()) {
                temp.offer(nextFloor);
            }
        }

        result.stream().forEach(System.out::println);

    }
}
