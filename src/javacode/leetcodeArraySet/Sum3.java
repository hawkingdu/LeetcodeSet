package javacode.leetcodeArraySet;

import java.util.*;
import java.util.stream.Collectors;

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
	 * 1. 先把数组排序
	 * 2. 依次遍历数据，每一个元素为a, 在剩下的数组里找b+c，利用左右指针法
	 * 3. 保存符合条件的组合，相同数值往后推
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		if(nums.length<3) {
			return result;
		}
		if (nums[0] > 0) {
			return result;
		}
		// 定义左右指针
		int right, left, target;
		for (int i = 0; i < nums.length - 1; i++) {
			if(i>0 && nums[i]==nums[i-1]){
				// 数字相同继续后移
				continue;
			}
			int a = nums[i]; // 当前a 的数值
			target = -a; // b+c 的数值
			left = i+1; // 遍历左指针
			right = nums.length-1; // 右指针
			while (right > left) {
				if (nums[right] + nums[left] == target) {
					result.add(Arrays.asList(a, nums[right], nums[left]));
					right--;
					left++;
					while (right > left && nums[right] == nums[right+1]){
						right--;
					}
					while (right > left && nums[left] == nums[left - 1]) {
						left++;
					}
				} else if (nums[right] + nums[left] < target) {
					left++;
				} else {
					right--;
				}
			}
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
