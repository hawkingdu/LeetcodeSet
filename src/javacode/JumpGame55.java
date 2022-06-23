package javacode;

import java.util.Arrays;

/**
 * @Author duhaojun
 * @Date 2022/6/16
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        /**
         * 每个节点是否可达
         */
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                /**
                 * 状态转移方程
                 * dp[i] 可达条件是 dp[0-i]间存在true且true的那个节点的距离够到当前距离
                 */
                if (dp[j] && (i-j)<=nums[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGame55 fg = new JumpGame55();
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println("fg.canJump(nums) = " + fg.canJump(nums));
    }
}
