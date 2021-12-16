package com.connor.jdk.algorithm;

import com.connor.jdk.algorithm.dto.NodeOneway;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class 链表排序 {

    /**
     * 4 7 3 8 1 5  2 6
     *
     * @param args
     */
    public static void main(String[] args) {
        NodeOneway header = new NodeOneway("4");
        header.buildNext(new NodeOneway("3"))
                .buildNext(new NodeOneway("3"))
                .buildNext(new NodeOneway("8"))
                .buildNext(new NodeOneway("1"))
                .buildNext(new NodeOneway("5"))
                .buildNext(new NodeOneway("2"))
                .buildNext(new NodeOneway("6"));

        NodeOneway nodeOneway = quickSort(header);
        nodeOneway.print();
    }

    private static NodeOneway quickSort(NodeOneway header) {

        if (header == null || header.getNext() == null) {
            return header;
        }

        //定义指针
        NodeOneway right = null;
        NodeOneway left = null;
        NodeOneway p1 = null;
        NodeOneway p2 = null;

        NodeOneway p = header.getNext();
        NodeOneway base = header;//基准面

        //遍历
        while (p != null) {
            if (Integer.parseInt(p.getValue()) < Integer.parseInt(base.getValue())) {
                //左小右大
                if (left == null){
                    p1 = left = p;
                } else {
                    p1.setNext(p);
                    p1 = p;
                }
            } else {
                if (right == null){
                    p2 = right = p;
                } else {
                    p2.setNext(p);
                    p2 = p;
                }
            }
            p = p.getNext();
        }
        if (p1 != null){
            p1.setNext(null);
        }
        if (p2 != null){
            p2.setNext(null);
        }
        base.setNext(null);


        //递归left&right
        if (left != null){
            left = quickSort(left);
        }
        if (left != null){
            right = quickSort(right);
        }

        //拼接
        base.setNext(right);
        if (left != null){
            NodeOneway tempLeft = left;
            while (tempLeft.getNext() != null){
                tempLeft = tempLeft.getNext();
            }
            tempLeft.setNext(base);
            return left;
        }
        return base;
    }


}
