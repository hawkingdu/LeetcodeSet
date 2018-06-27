package javacode.leetcodeArraySet;

import java.util.*;

/**
 * 
 * 	Given a set of distinct integers, nums, return all possible subsets (the power set).
	Note: The solution set must not contain duplicate subsets.
	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 *
 */
public class Subsets {

	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>(new ArrayList<>());
		backtracking(result, new ArrayList<>(), nums, 0);
		return result;
    }
	
	public void backtracking(List<List<Integer>> result, List<Integer> subList, int[] nums, int begin){
		if(!result.contains(subList)) result.add(new ArrayList<>(subList));
		for(int i=begin; i<nums.length; i++){
			subList.add(nums[i]);
			backtracking(result, subList, nums, i+1);
			subList.remove(subList.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Subsets sets = new Subsets();
		int[] nums = {1, 2, 3,4};
		System.out.println(sets.subsets(nums));
	}

}
