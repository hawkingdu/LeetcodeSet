package javacode.leetcodeArraySet;

import java.util.*;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * 	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}
	
	public void backtrack(List<List<Integer>> result, List<Integer> subList, int[] nums){
		if(subList.size()==nums.length) { // set return condition
			result.add(new ArrayList<>(subList));
		} else {
			for(int i=0; i<nums.length; i++){
				if(subList.contains(nums[i])) continue; 
				subList.add(nums[i]);	// push element into stack
				backtrack(result, subList, nums);
				subList.remove(subList.size()-1); // pop element from stack
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations cs = new Permutations();
		int[] nums = {1,2,3};
		System.out.println(cs.permute(nums));
	}

}
