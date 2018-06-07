package javacode.leetcodeArraySet;

import java.util.*;

/**
 * 15. 3Sum
 * Given array nums = [-1, 0, 1, 2, -1, -4],

	A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 *
 */
public class Sum3 {

	/**
	 * 1. Sort integer array
	 * 2. loop array, each element is first element, then make bi-directional 2Sum sweep in remaining of array
	 * 3. Record qualified element, if next element is equal that, move to next
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if(nums.length<3) return result;
		Arrays.sort(nums);
		int lo, hi, sum, temphi, templo;
		for(int i=0; i<nums.length-2; i++){
			sum = 0 - nums[i];
			lo=i+1;
			hi=nums.length-1;
			while(hi>lo){
				if(nums[lo] + nums[hi] == sum){
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					temphi = hi;
					templo = lo;
					hi--;
					while(hi>lo && nums[hi]==nums[temphi])hi--;
					lo++;
					while(hi>lo && nums[lo]==nums[templo])lo++;
				} else if(nums[lo] + nums[hi] > sum){
					hi--;
				} else {
					lo++;
				}
			}
			while(i<nums.length-2 && nums[i]==nums[i+1])i++;
			if(nums[i]>0) break;
		}
		return result;
    }
	
	public static int[] sumAmount(int[] nums, int amount){
		int[][] dp = new int[nums.length+1][amount+1];
		nums = Arrays.copyOf(nums, nums.length+1);
		for(int k=nums.length-1; k>0; k--){
			nums[k] = nums[k-1];
		}
		nums[0] = 0;
		for(int i=1; i<dp.length; i++){
			for(int j=amount; j>=nums[i]; j--){
				dp[i][j] = Math.max(nums[i]+dp[i-1][j-nums[i]], dp[i-1][j]);
			}
		}
		int[] result = new int[nums.length];
		int k = 0;
		for(int i=nums.length-1; i>0; i--){
			if(dp[i][amount] > dp[i-1][amount]){
				result[k++] = nums[i];
				amount = amount - nums[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{-2,0,1,1,2};
		Sum3 sum = new Sum3();
		List<List<Integer>> list = sum.threeSum(nums);
		System.out.println(list);


	}

}
