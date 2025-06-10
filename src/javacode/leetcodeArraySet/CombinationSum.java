package javacode.leetcodeArraySet;


import java.util.*;
import java.util.stream.Collectors;

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
		backtrack(result, new ArrayDeque<>(), nums, target, 0);
		return result;
    }
	public void backtrack(List<List<Integer>> result, ArrayDeque<Integer> subList, int[] nums, int remain, int start){
		if(remain<0){
			return; // 终止条件
		}
		else if(remain ==0 ) {
			result.add(new ArrayList<>(subList)); // 终止条件
		}
		else{
			/**
			 * start 从上层传入，递进式遍历，可防止出现重复数组，如[2,5] [5,2]
			 */
			for(int i=start; i<nums.length; i++){
				subList.addLast(nums[i]);
				backtrack(result, subList, nums, remain-nums[i], i);
				subList.removeLast();
			}
		}
	}

	/**
	 * 先排序
	 * 因为是有序数组，遍历时可进行剪枝
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		/**
		 * 先排序，避免产生重复问题，如[2,5] 和 [5,2]
		 */
		Arrays.sort(candidates);
		dfs(list, new ArrayList<>(), candidates, target, 0, 0);
		return list;
	}

	public void dfs(List<List<Integer>> list, List<Integer> subList, int[] candidates, int target, int val, int index){
		if (val > target) {
			return;
		} else if (val == target){
			list.add(new ArrayList<>(subList));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			/**
			 * 因为是正排序数组，所以当val+candidates[i]> target 时，后面的不用再遍历了
			 */
			if (val+candidates[i] >target){
				break;
			}
			subList.add(candidates[i]);
			dfs(list, subList, candidates, target, val+candidates[i], i);
			subList.remove(subList.size()-1);
		}
	}
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums = {2,5,3};
		System.out.println(cs.combinationSum2(nums, 8));
	}




}
