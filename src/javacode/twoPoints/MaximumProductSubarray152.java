package javacode.twoPoints;

/**
 * @Author duhaojun
 * @Date 2022/6/21
 */
public class MaximumProductSubarray152 {
    /**
     * 暴力法，双循环
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            max = Math.max(product, max);
            for (int j = i+1; j < nums.length; j++) {
                product *= nums[j];
                max = Math.max(product, max);
            }
        }
        return max;
    }
    public int maxProduct2(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]) );
            minDp[i] = Math.min(nums[i], Math.min(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]) );
            max = Math.max(max, maxDp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-5,-2,-4,3};
        MaximumProductSubarray152 subarray152 = new MaximumProductSubarray152();
        int i = subarray152.maxProduct2(nums);
        System.out.println(i);
    }
}
