package com.connor.jdk.algorithm;

import com.connor.jdk.algorithm.dto.TreeNode;

import java.util.LinkedList;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * /**
 * * Definition for a binary tree node.
 * * public class TreeNode {
 * *     int val;
 * *     TreeNode left;
 * *     TreeNode right;
 * *     TreeNode(int x) { val = x; }
 * * }
 */
public class 树的子结构 {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4, one, two);
        TreeNode A = new TreeNode(3, four, five);
        TreeNode B = new TreeNode(4, one, null);
        TreeNode.printTree(A);

        boolean sub = isSub(A, B);
        System.out.println(sub);


    }

    private static boolean isSub(TreeNode a, TreeNode b) {

        if (a == null || b == null) {
            return false;
        }

        boolean recur = isRecur(a, b);
        if (recur) {
            return true;
        }

        boolean sub = isSub(a.getRight(), b);
        if (sub) {
            return true;
        }
        boolean sub1 = isSub(a.getLeft(), b);
        if (sub1) {
            return true;
        }

        return false;
    }

    private static boolean isRecur(TreeNode a, TreeNode b) {

        if (b == null) {
            return true;
        }
        if (a == null || a.getVal() != b.getVal()) {
            return false;
        }

        //判断子链
        return isRecur(a.getLeft(), b.getLeft()) && isRecur(a.getRight(), b.getRight());
    }



}

