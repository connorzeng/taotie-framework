package com.connor.jdk.algorithm;

public class 只出现一次的数字 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String a = "";
        a.hashCode();
        int[] nums = new int[]{1, 2,2, 3,3};

        System.out.println(singleNumber2(nums));
    }

    /**
     * 给定一个整数数组，除了某个元素外其余元素均出现两次
     * 要在这个限定条件才有效
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
