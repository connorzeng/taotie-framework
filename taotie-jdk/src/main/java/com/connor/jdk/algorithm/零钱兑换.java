package com.connor.jdk.algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class 零钱兑换 {

    public static void main(String[] args) {

        int[] coins = new int[]{2, 3, 5};
        int amout = 11;
        int i = coinChange(coins, amout);

        int nums = coinChangeDp(coins, amout);


        System.out.println(nums);
    }

    private static int coinChangeDp(int[] coins, int amout) {

        Arrays.sort(coins);
        int[] dp = new int[amout + 1];
        Arrays.fill(dp, amout + 1);
        dp[0] = 0;

        //f(0) = 0
        //f(1) = -1
        //f(2) = f(2-2) + 1 = 1
        //f(3) = f(3-2) + 1| f(3-3) + 1 = 1
        //f(4) = f(4-2) + 1 = 2
        //f(6) = f();
        //f(8) = f(8-2) + 1 =
        for (int money = 1; money <= amout; money++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= money) {
                    dp[money] = Math.min(dp[money], dp[money - coins[j]] + 1);
                }
            }

        }

        return dp[amout] > amout ? -1 : dp[amout];
    }


    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];//dp[11] = min( dp[10] + 1 )
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
