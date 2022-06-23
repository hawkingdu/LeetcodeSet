package javacode;

import java.util.Arrays;

/**
 * @Author duhaojun
 * @Date 2022/6/16
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int max = 0;
        int incr = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                incr++;
            } else if (nums[i] == nums[i - 1]){
            } else {
                max = Math.max(max, incr);
                incr = 1;
            }
        }
        max = Math.max(max, incr);
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence128 sequence128 = new LongestConsecutiveSequence128();
        int[] nums = new int[]{1,2,0,1};
        int res = sequence128.longestConsecutive(nums);
        System.out.println(res);
    }
}
