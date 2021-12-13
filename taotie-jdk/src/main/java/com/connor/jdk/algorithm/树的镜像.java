package com.connor.jdk.algorithm;

import com.connor.jdk.algorithm.dto.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 树的镜像 {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        TreeNode two = new TreeNode(2, three, one);
        TreeNode five = new TreeNode(7, nine, six);
        TreeNode A = new TreeNode(4, five, two);

        TreeNode.printTree(A);
        mirrior(A);
        System.out.println("-----------------");
        TreeNode.printTree(A);
        //TreeNode.printTreeZ(A);


    }

    private static void mirrior(TreeNode a) {
        if (a == null) {
            return;
        }
        TreeNode leftTemp = a.getLeft();
        a.setLeft(a.getRight());
        a.setRight(leftTemp);

        mirrior(a.getLeft());
        mirrior(a.getRight());

    }


}

