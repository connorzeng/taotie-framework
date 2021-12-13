package com.connor.jdk.algorithm.dto;

import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public static void printTree(TreeNode treeNode) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(treeNode);
        while (list.peek() != null) {
            TreeNode poll = list.poll();
            System.out.println(poll.getVal());
            if (poll.getLeft() != null) {
                list.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                list.offer(poll.getRight());
            }
        }
    }

    /**
     * Z自行周游
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param
     */
    public static void printTreeZ(TreeNode treeNode) {


        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(treeNode);
        list.offer(null);//作为分割符号.

        LinkedList<TreeNode> levelList = new LinkedList<>();

        boolean leftToRight = false;
        while (!list.isEmpty()) {


            TreeNode poll = list.poll();
            if (poll == null) {
                if (levelList.isEmpty()){
                    break;
                }
                levelList.addLast(null);
                list.addAll(levelList);
                leftToRight = !leftToRight;
                levelList.clear();
                continue;
            }
            System.out.println(poll.getVal());

            if (leftToRight) {
                if (poll.getRight() != null) {
                    levelList.addFirst(poll.getRight());
                }
                if (poll.getLeft() != null) {
                    levelList.addFirst(poll.getLeft());
                }
            } else {
                if (poll.getLeft() != null) {
                    levelList.addFirst(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    levelList.addFirst(poll.getRight());
                }
            }


        }

    }


}
