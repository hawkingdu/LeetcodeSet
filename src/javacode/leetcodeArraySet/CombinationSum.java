package javacode.leetcodeArraySet;

import java.util.*;
/**
 * 	39. Combination Sum
 * 	Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
	The same repeated number may be chosen from candidates unlimited number of times.
 *	Input: candidates = [2,3,6,7], target = 7,
	A solution set is:
	[ [7],
	  [2,2,3]
	]
	
 * 	Input: candidates = [2,3,5], target = 8,
	A solution set is:
	[ [2,2,2,2],
  	  [2,3,3],
  	  [3,5]
	]
	
	discussion: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
//		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, target, 0);
		return result;
    }
	public void backtrack(List<List<Integer>> result, List<Integer> subList, int[] nums, int remain, int start){
		if(remain<0) return; // set return condition
		else if(remain ==0 ) {
			result.add(new ArrayList<>(subList)); // set return condition
		}
		else{
			for(int i=start; i<nums.length; i++){
				subList.add(nums[i]);
				backtrack(result, subList, nums, remain-nums[i], i);
				subList.remove(subList.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums = {3,7,6,4};
		System.out.println(cs.combinationSum(nums, 20));
	}

}
