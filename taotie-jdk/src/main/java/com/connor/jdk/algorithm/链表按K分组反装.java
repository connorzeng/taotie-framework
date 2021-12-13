package com.connor.jdk.algorithm;


import com.connor.jdk.algorithm.dto.NodeOneway;

public class 链表按K分组反装 {

    public static void main(String[] args) {
        //1->2->3->4->5->6->7->8->0->1
        //3 2 1   6 5 4  0 8 7  1
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
                .buildNext(new NodeOneway("1"))
                .buildNext(new NodeOneway("2"));
        header.print();
        NodeOneway nodeOneway = revertGroupK(header, 3);
        System.out.println("--------------------------");
        nodeOneway.print();
    }

    private static NodeOneway revertGroupK(NodeOneway header, int k) {

        if (header == null || header.getNext() == null || k <= 1) {
            return header;
        }

        //1 2 3 4 5 6 7 8
        //3 2 1     4 5 6   7 8
        //3 2 1     6 5 4   7 8

        int index = 1;
        NodeOneway currentHeader = header;
        NodeOneway revertTail = header;

        NodeOneway lasterGroup = header;//1
        NodeOneway nextGroup = header;//4

        boolean firstGroup = true;
        NodeOneway result = header;
        while (revertTail != null) {

            if (index < k) {

                revertTail = revertTail.getNext();
                index++;
            } else {
                //revertTail=3
                //nextGroup=4
                nextGroup = revertTail.getNext();//4

                NodeOneway reverse = reverse(currentHeader, revertTail);
                if (firstGroup){
                    result = reverse;
                    lasterGroup.setNext(nextGroup);
                    firstGroup = false;
                } else {
                    lasterGroup.setNext(reverse);
                }


                lasterGroup = currentHeader;//4
                currentHeader = nextGroup;
                revertTail = nextGroup;
                index = 1;
            }
        }

        if (index <= k){
            lasterGroup.setNext(currentHeader);
        }


        return result;
    }


    public static NodeOneway reverse(NodeOneway head, NodeOneway tail) {
        NodeOneway pre = head;
        NodeOneway cur = head.getNext();
        NodeOneway ne = null;
        while (pre != tail) {
            ne = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = ne;
        }
        head.setNext(null);
        head = pre;
        return head;
    }


}
