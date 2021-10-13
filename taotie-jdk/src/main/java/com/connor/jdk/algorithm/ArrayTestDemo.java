package com.connor.jdk.algorithm;

//https://www.nowcoder.com/discuss/657966?type=2
public class ArrayTestDemo {

    public static void main(String[] args) {





    }
    //最大子序和
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
