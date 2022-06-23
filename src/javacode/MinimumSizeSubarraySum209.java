package javacode;


/**
 * @Author duhaojun
 * @Date 2022/6/7
 */
public class MinimumSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        boolean hit = false;
        int min = nums.length, left =0, right=0, sum = nums[0];
        while (right < nums.length && left <= right) {
            if (sum >= target) {
                hit = true;
                min = Math.min( right - left +1, min);
                sum -= nums[left++];
            } else if (sum < target) {
                right++;
                if (right >= nums.length) {
                    break;
                } else {
                    sum += nums[right];
                }
            }
        }
        if (hit){
            return min;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum209 sum209 = new MinimumSizeSubarraySum209();
        int res = sum209.minSubArrayLen(5, new int[]{1,1,3,4});
        System.out.println(res);
    }
}
