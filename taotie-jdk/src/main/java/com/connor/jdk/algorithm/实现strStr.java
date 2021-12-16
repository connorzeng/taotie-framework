package com.connor.jdk.algorithm;

public class 实现strStr {

//    实现 strStr() 函数。
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
//    字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

    public static void main(String[] args) {

        int i = strStr("a", "a");
        System.out.println(i);

    }


    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
     * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null ) {
            return -1;
        }
        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()){
            return -1;
        }


        //haystack  needle
        for (int i = 0; i < haystack.length(); i++) {
            int restLength = haystack.length() - i - 1;
            if (restLength < needle.length()-1){
                return -1;
            }
            boolean flag = true;
            int orgIndex = i;
            for (int j = 0; j < needle.length();j++){
                if (needle.charAt(j) != haystack.charAt(orgIndex)){
                    flag = false;
                    break;
                }
                orgIndex ++;
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }


}
