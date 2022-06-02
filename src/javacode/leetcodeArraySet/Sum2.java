package javacode.leetcodeArraySet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				int b = nums[j];
				if ((a+b) == target) {
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1};
    }

	public int[] twoSumWithMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			Integer j = map.get(target - a);
			if (j != null) {
				return new int[]{i,j};
			}
			map.put(a, i);
		}
        return null;
    }
	public static void main(String[] args) {
		Sum2 sum = new Sum2();
		int[] nums = {2,3,1,-3,0,2,-4,5};
		for(int i :sum.twoSum(nums, 7)){
			System.out.println(i);
		}
		int[] nums2 = {3,4,2};
		IntStream.of(sum.twoSumWithMap(nums2, 6)).forEach(System.out::print);

	}

}
