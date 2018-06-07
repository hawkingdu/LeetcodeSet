package javacode.leetcodeArraySet;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1. Two Sum
 *
 *	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	Given nums = [2, 7, 11, 15], target = 9,
	return [0, 1].
 */
public class Sum2 {

	public int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		int lo=0, hi=nums.length-1;
		int[] result = new int[2];
		while(hi>lo){
			if(nums[lo]+nums[hi] == target){
				result[0]=lo;
				result[1]=hi;
				break;
			} else if(nums[lo] + nums[hi] > target) {
				hi--;
			} else {
				lo++;
			}
		}
        return result;
    }
	
	public int[] twoSumWithMap(int[] nums, int target) {
		
        return null;
    }
	public static void main(String[] args) {
		Sum2 sum = new Sum2();
		int[] nums = {2,3,1,-3,0,2,-4,5};
		for(int i :sum.twoSum(nums, 7)){
			System.out.println(i);
		}
		IntStream.of(sum.twoSum(nums, 7)).forEach(System.out::print);

	}

}
