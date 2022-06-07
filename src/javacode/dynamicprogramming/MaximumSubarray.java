package javacode.dynamicprogramming;

import javacode.leetcodeUtil.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author duhaojun
 * @Date 2022/6/2
 */
public class MaximumSubarray {
    /**
     * 动态规划
     * 1. 定义状态：p[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和
     * 2. 状态转移方程：
     * 如果 dp[i - 1] > 0，那么可以把 nums[i] 直接接在 dp[i - 1] 表示的那个数组的后面，得到和更大的连续子数组；
     * 如果 dp[i - 1] <= 0，那么 nums[i] 加上前面的数 dp[i - 1] 以后值不会变大。于是 dp[i] 「另起炉灶」，此时单独的一个 nums[i] 的值，就是 dp[i]。
     * dp[i] = max{ nums[i], dp[i−1]+nums[i] }
     * 3. 思考初始值
     * dp[0] 根据定义，只有 1 个数，一定以 nums[0] 结尾，因此 dp[0] = nums[0]
     * 4. 思考决策
     * 这个问题的输出是把所有的 dp[0]、dp[1]、……、dp[n - 1] 都看一遍，取最大值。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        /**
         * 状态定义
         * dp[i] 表示以nums[i] 为结尾的最大子数组和
         * 举例： [-2,1,1]
         * dp[0] = -2, dp[1]=1, dp[2]=2
         */
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /**
             * 状态转移方程
             * dp[i-1] > 0 有利用价值，可以使结果更优，dp[i] = dp[i-1] + num[i]
             * dp[i-1] <=0 没有利用价值，当前值为最优，dp[i]=num[i]
             */
            if (dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            /**
             * 决策
             * 记录最大的dp[i]
             */
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = StringUtil.stringToIntegerArray(line);

            int ret = new MaximumSubarray().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}
