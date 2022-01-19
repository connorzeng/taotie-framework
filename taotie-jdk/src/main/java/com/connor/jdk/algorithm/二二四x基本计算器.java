package com.connor.jdk.algorithm;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class 二二四x基本计算器 {

    public static void main(String[] args) {

        System.out.println(calculate(" 2-1 + 2 "));

    }

    /**
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * s 表示一个有效的表达式
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        // 使用一个栈来解决
        int result = 0;
        int index = 0;
        int sign = 1;
        Stack<Integer> calStack = new Stack<>();
        calStack.push(sign);

        while (index < s.length()) {
            Character cur = s.charAt(index);
            if (cur == ' ') {
                index++;
                continue;
            } else if (cur == '-') {
                sign = -calStack.peek();//是peek,不是pop在push
            } else if (cur == '+') {
                sign = calStack.peek();//是peek,不是pop在push
            } else if (cur == '(') {
                calStack.push(sign);
            } else if (cur == ')') {
                calStack.pop();
            } else {
                // 考虑多位的情况
                int curNum = 0;
                while (index < s.length()) {
                    char c = s.charAt(index);
                    if ('0' <= c && c <= '9') {
                        curNum = curNum * 10 + (s.charAt(index) - '0');
                    } else {
                        break;
                    }
                    index++;
                }
                result += sign * curNum;
                index--;
            }

            index++;
        }
        return result;
    }

}
