package com.connor.jdk.algorithm;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class 最大数值 {

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArrayResult(nums);

        System.out.println(result);

    }

    private static int maxSubArrayResult(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {

            if (dp[i-1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }


}
