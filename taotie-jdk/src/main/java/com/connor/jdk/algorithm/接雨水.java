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
        System.out.println(i);
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
