package com.connor.jdk.algorithm;


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

