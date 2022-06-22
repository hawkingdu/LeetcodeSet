package javacode.leetcodeArraySet;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		backtrack2(result, new ArrayList<>(), nums);

		return result;
	}
	
	public void backtrack(List<List<Integer>> result, List<Integer> subList, int[] nums){
		if(subList.size()==nums.length) { // set return condition
			result.add(new ArrayList<>(subList));
		} else {
			for(int i=0; i<nums.length; i++){
				if(subList.contains(nums[i])){
					continue;
				}
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




	public void backtrack2(List<List<Integer>> result,List<Integer> cur,  int[] nums) {
		/**
		 * 退出条件
		 */
		if (cur.size() == nums.length) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			/**
			 * 已经搜索过的不能出现
			 */
			if (cur.contains(nums[i])) {
				continue;
			}
			cur.add(nums[i]);
			backtrack2(result, cur, nums);
			cur.remove(cur.size()-1);
		}
		
	}









}
