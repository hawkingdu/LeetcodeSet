package javacode.leetcodeArraySet;

/**
 * 53. Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * 	Input: [-2,1,-3,4,-1,2,1,-5,4],
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

	/**
	 * Complexity O(n*n)
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		for(int i=0; i<nums.length; i++){
			int temp = nums[i], sum =nums[i];
			for(int j=i+1; j<nums.length; j++){
				sum += nums[j];
				temp = Math.max(temp, sum);
			}
			max = Math.max(max, temp);
		}
		return max;
    }
	
	/**
	 * Complexity O(n)
	 * 
	 * 贪心算法
	 * step 1 get end with nums[i] max sum value between
	 * step 2 compare end with nums[i] and end with nums[i-1] sum  
	 * 
	 * https://blog.csdn.net/the__apollo/article/details/77367534
	 */
	public int maxSubArray2(int[] nums){
		int end_max = nums[0], sum_max = nums[0];
		for(int i=1; i<nums.length; i++){
			end_max = Math.max(end_max + nums[i], nums[i]);
			sum_max = Math.max(sum_max, end_max);
		}
		return sum_max;
	}
	
	public static void main(String[] args) {
		MaximumSubarray subarray = new MaximumSubarray();
		int[] nums = {-2,1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(subarray.maxSubArray2(nums));
	}

}
