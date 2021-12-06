package com.connor.jdk.algorithm;


import java.util.Stack;

/**
 *
 */
public class 接雨水 {

    //https://zhuanlan.zhihu.com/p/79811305

    public static void main(String[] args) {
        //左右两边不需要考虑
        //左边最高  右边最高
        //需要使用动态规划减少重复运算.
//        System.out.println(5>>3);//结果是0
//        System.out.println(-5>>4);//结果是-1,最多移动到-1
//        System.out.println(-5>>>3);//结果是536870911
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int i = trap6(height);

        int j = minStatic(height);
        System.out.println(i);
    }

    public static int minStatic(int[] height) {

        int sum = 0;

        // 面试官,你的需求是要返回0,还是报错?
        if (height.length <= 2 || height == null) {
            return sum;
        }

        // 栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {

            // 当前必须必入栈的柱子高,才能接住雨水
            // 水池一个台阶while循环一次
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int bashH = height[stack.pop()];//地基的尺寸
                if (stack.empty()){
                    //相邻的两个矮柱子,不盛水
                    break;
                }

                // 计算两堵墙之间的距离
                int distance = i - stack.peek() - 1;
                // 水平面的深度(两堵强中最矮的那堵墙)
                int waterH = Math.min(height[i],height[stack.peek()]);

                sum += distance * (waterH - bashH);
            }
            stack.push(i);
        }
        return 0;
    }


    public static int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

}
