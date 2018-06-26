package javacode.leetcodeArraySet;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers.
 * Example:
	Given array nums = [-1, 2, 1, -4], and target = 1.
	The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class Sum3Cloest {
	
	/**
	 * two pointers algorithm
	 * 
	 * 1. sort integer array
	 * 2. loop each integer
	 * 3. sum = nums[i] + nums[left] + nums[right]
	 * 4. delta = Math.min(delta, Math.abs(sum-target))
	 * 5. if(Math.abs(sum-target) < delta) result = sum
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int delta= Integer.MAX_VALUE;
		int result= Integer.MAX_VALUE;
		for(int i=0; i<nums.length-2; i++){
			int left = i+1,  right= nums.length-1;
			while(left < right){
				if(Math.abs(nums[left] + nums[right] + nums[i] -target)<delta){
					result = nums[left] + nums[right] + nums[i];
					delta = Math.abs(nums[left] + nums[right] + nums[i] -target);
				}
				if( nums[left] + nums[right] + nums[i] == target) return target;
				if( nums[left] + nums[right] + nums[i]> target ){
					right--;
				} else {
					left++;
				}
			}
		}
		return result;
    }

	public static void main(String[] args) {
		Sum3Cloest sum = new Sum3Cloest();
		int[] nums = {-1, 2, 1, -4};
		System.out.println(sum.threeSumClosest(nums, 10));
	}

}
