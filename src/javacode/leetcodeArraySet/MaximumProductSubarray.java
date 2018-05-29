package javacode.leetcodeArraySet;

/**
 * 152. Maximum Product Subarray
 * 
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
	Input: [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
 *
 */
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		int max = nums[0], max_end=nums[0];
		if(nums.length>1){
			for(int i=1; i<nums.length; i++){
				
				max_end = Math.max(max_end * nums[i], nums[i]);
				max	= Math.max(max, max_end);
			}
		}
        return max;
    }
	
	public int maxProduct2(int[] nums) {
		int max = nums[0],  product=0;
		if(nums.length>1){
			for(int i=0; i<nums.length-1; i++){
				product = nums[i];
				int subsum = nums[i];
				for(int j=i+1; j<nums.length; j++){
					product = product * nums[j];
					subsum = Math.max(subsum, product);
				}
				max = Math.max(max, subsum);
			}
			max = Math.max(max, nums[nums.length-1]);
		}
        return max;
    }
	
	public static void main(String[] args) {
		MaximumProductSubarray getResult = new MaximumProductSubarray();
		int[] nums = {2,0,0};
		System.out.println(getResult.maxProduct2(nums));

	}

}
