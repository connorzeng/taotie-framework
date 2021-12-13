package com.connor.jdk.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 最长不重复字符 {

    public static void main(String[] args) {

        String a = "abcabcbb";
        int maxSubLenght = maxSubNoSameLength(a);
        System.out.println(maxSubLenght);

    }

    private static int maxSubNoSameLength(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> cMap = new HashMap<>();
        cMap.put(str.charAt(0), 1);
        //abcabcbb
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < str.length(); i++) {
            if (cMap.get(str.charAt(i)) != null) {
                //重复了,重置cMap
                dp[i] = 1;
                cMap.clear();
                cMap.put(str.charAt(i), 1);
            } else {
                dp[i] = dp[i - 1] + 1;
                cMap.put(str.charAt(i), 1);
            }
            max = Math.max(max, dp[i]);
        }


        return max;
    }

}
