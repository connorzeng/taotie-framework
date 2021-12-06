package com.connor.jdk.algorithm;

public class 异动字符串 {

    public static void main(String[] args) {

        char b = 'b';
        char a = 'a';

        System.out.println(a - 0);
        System.out.println(b - a);
    }


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }

}
