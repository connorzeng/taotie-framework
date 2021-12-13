package com.connor.jdk.algorithm;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class 连续子数组的最大和 {

    public static void main(String[] args) {

        int[] leght = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int a = dpResolver(leght);

        System.out.println(a);

    }

    private static int dpResolver(int[] array) {


        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = Math.max(0,dp[0]);

        int i = 1;
        while (i < array.length) {
            if (dp[i-1] <=0 ){
                dp[i] = array[i];
            } else {
                dp[i] = dp[i-1] + array[i];
            }
            max = Math.max(max,dp[i]);
            i++;
        }
        return max;
    }

}
