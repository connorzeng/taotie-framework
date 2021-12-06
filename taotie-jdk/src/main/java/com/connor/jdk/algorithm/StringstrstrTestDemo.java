package com.connor.jdk.algorithm;

public class StringstrstrTestDemo {

    public static void main(String[] args) {
        //一.最长公共前缀
//        输入: ["flower","flow","flight"]
//        输出: "fl"
        String[] strs = new String[]{"flower", "flow", "flight"};
        maxPrefixStr(strs);
    }

    private static String maxPrefixStr(String[] strs) {

        //暴力破解法
        //对str[0]按字符遍历，与其他字符串依次比较对应位置上的字符，并记录查找位置，如果找到不相等或者对应字符串的长度到了限制，就找到了。
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = (char) strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i) || i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

}
