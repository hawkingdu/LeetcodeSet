package javacode.leetcodeArraySet;

/**
 * @Author duhaojun
 * @Date 2022/6/21
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,4,5};
        SingleNumber136 number136 = new SingleNumber136();
        System.out.println(number136.singleNumber(nums));
    }
}
