package javacode.leetcodeArraySet;

import java.util.*;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtracking(result, new ArrayList<>(), nums, target, 0);
        return result;
    }
	
	public void backtracking(List<List<Integer>> result, List<Integer> subList, int[] nums, int remain, int start){
		if(remain<0) return;
		else if(remain==0) {
			result.add(new ArrayList<>(subList));
		} else {
			for(int i=start; i<nums.length; i++){
				if(i>start && nums[i]==nums[i-1]) continue;
				subList.add(nums[i]);
				backtracking(result, subList, nums, remain-nums[i], i+1);
				subList.remove(subList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,5,6,7,10};
		CombinationSum2 sum = new CombinationSum2();
		System.out.println(sum.combinationSum2(nums, 8));
	}

}
