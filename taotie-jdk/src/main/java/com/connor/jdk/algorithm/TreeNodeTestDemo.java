package com.connor.jdk.algorithm;


import java.util.ArrayDeque;

/**
 * 遍历树的操作
 */
public class TreeNodeTestDemo {

    /**
     * 构建树
     *    1
     *  2   3
     * 4 5  6 7
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
        secRight.setRight(new TreeNode(7));



        //一.层序遍历
        //1   23    456
        //需要借助队列
        ArrayDeque<TreeNode> tempDeque = new ArrayDeque<>();
        //root入队列
        tempDeque.offer(root);
        while(tempDeque.peek()!=null){
            TreeNode top = tempDeque.poll();
            //遍历打印数据
            System.out.println(top.getValue());
            if (top.getLeft()!=null){
                tempDeque.offer(top.getLeft());
            }
            if (top.getRight()!=null){
                tempDeque.offer(top.getRight());
            }
        }

        //前序遍历：根结点 ---> 左子树 ---> 右子树  1245367
        //中序遍历：左子树---> 根结点 ---> 右子树   4251637
        //后序遍历：左子树 ---> 右子树 ---> 根结点
        System.out.println("前序遍历");
        frontItrTree(root);
        System.out.println();
        System.out.println("中序遍历");
        middleItrTree(root);
        System.out.println();
        System.out.println("后序遍历");
        endItrTree(root);

    }
    // 根 左 右 1245367
    private static void frontItrTree(TreeNode<Integer> root) {
        if (root == null){
            return;
        }
        System.out.print(root.getValue());
        frontItrTree(root.getLeft());
        frontItrTree(root.getRight());
    }
    // 左 根 右 4251637
    private static void middleItrTree(TreeNode<Integer> root) {

        if (root == null){
            return;
        }
        middleItrTree(root.getLeft());
        System.out.print(root.getValue());
        middleItrTree(root.getRight());
    }

    // 左  右  根 4526731
    private static void endItrTree(TreeNode<Integer> root) {

        if (root == null){
            return;
        }
        endItrTree(root.getLeft());
        endItrTree(root.getRight());
        System.out.print(root.getValue());
    }
}

class TreeNode<T> {

    private T value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(){
    }

    public TreeNode(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
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
}

