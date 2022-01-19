package com.connor.jdk.loaderbalance;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRind {

    /**
     * 简介：
     * 1， 将目标放在一容器内
     * 2，定义一标识，记录上次访问的该目标的对象（标识应该是索引等，需要有规律性）
     * 3，（标识加一）取模，然后获取到该目标对象，同事更新该目标标识
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int index = 4;//索引：指定开始位置
        for (int i = 0; i < 17; i++) {
            int nextIndex = (index + 1) % arr.length;
            index = nextIndex;
            System.out.println(arr[index] + ",index=" + index);
        }

        // Initially value as 0
        AtomicInteger val
                = new AtomicInteger();

        // Update the value
        int c = val.addAndGet(6);

        // Prints the updated value
        System.out.println("Updated value: "
                + c);
    }

}
