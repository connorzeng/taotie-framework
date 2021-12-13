package com.connor.jdk.algorithm;

import java.util.Arrays;

/**
 * 322
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * d[11] = d[10] + 1//10+1快
 * d[11] = 1 //刚好一块
 */
public class 零钱兑换 {

    public static void main(String[] args) {
        int reslut = coinChange(new int[]{1,2,5},11);
        System.out.println(reslut);
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {//amount从1块钱开始
            for (int j = 0; j < coins.length; j++) {//遍历一块钱的dp
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//硬币要排序
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
