package com.connor.jdk.algorithm;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二十有效的括号 {
    private static Map<Character, Character> META = new HashMap<>();

    static {
        META.put('(', ')');
        META.put('{', '}');
        META.put('[', ']');
        META.put(')', '(');
        META.put('}', '{');
        META.put(']', '[');
    }

    public static void main(String[] args) {


        System.out.println(isValid("()"));

        boolean valid = isValid("()[]{}");
        System.out.println(valid);

    }

    private static boolean isValid(String s) {

        if (s == null || s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()){

            Character current = s.charAt(index);

            if (!stack.empty() && stack.peek().equals(META.get(current))){
                //出栈
                stack.pop();
            } else {
                stack.push(current);
            }
            index ++;
        }

        if (stack.empty()){
            return true;
        } else {
            return false;
        }

    }


    /**
     * 必须全匹配
     * {[]}"
     *
     * @param s
     * @return
     */
    public static boolean isValidFull(String s) {

        if (s == null || s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }

        int front = 0;
        int bankend = s.length() - 1;
        while (front < bankend) {
            Character frontChar = s.charAt(front);
            Character bankendChar = s.charAt(bankend);
            if (!bankendChar.equals(META.get(frontChar))) {
                return false;
            }

            front++;
            bankend--;
        }

        return true;
    }
}

