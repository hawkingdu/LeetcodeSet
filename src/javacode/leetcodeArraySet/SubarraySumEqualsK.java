package javacode.leetcodeArraySet;

/**
 * @Author duhaojun
 * @Date 2022/6/21
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sub = 0;
            for (int j = i; j < nums.length; j++) {
                sub += nums[j];
                if (sub == k){
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SubarraySumEqualsK equalsK = new SubarraySumEqualsK();
        int[] nums = new int[]{1,-1,0};
        System.out.println(equalsK.subarraySum(nums, 0));
    }
}
