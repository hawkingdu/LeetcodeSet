package javacode.dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

/**
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * @Date 2022/6/7
 */
public class LongestIncreasingSubsequence {
    /**
     * 1. 定义状态
     * 2. 状态转移方程
     * 3. 决策
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        // 定义状态 dp[i] 保存以nums[i]为结尾的最大递增数组长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            /**
             * 转移方程，两次循环
             * 如果 nums[j] 小于 nums[i]
             * dp[j] + 1 和 dp[i] 比较，取大
             */
            for (int j = 0 ; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i]= Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] nums = new int[]{0,1,0,3,2,3};
        int res = subsequence.lengthOfLIS(nums);
        System.out.println(res);
    }


    public int lengthOfLIS2(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        return max;
    }


















}
