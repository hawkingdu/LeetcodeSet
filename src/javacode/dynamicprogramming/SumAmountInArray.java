package javacode.dynamicprogramming;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 
 * 在一个整形数组中，以一定条件求和
 * 例： 	1， 在一个数组中求和等于 n 的子数组
 * 		2， 在一个数组中求出全部满足和等于n 的子数组集合
 * 		3， 在一个数组中求出和等于n 的子数字且元素数量最少
 */
public class SumAmountInArray {

	/**
	 * 在一个数组中求和等于 n 的子数组
	 * 动态规划法
	 * 定义dp二维数组dp = new int[nums.length+1][amount+1]
	 * 从amount值开始遍历，求出自身值和自身值相加最优解
	 */
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
	
	/**
	 * 在一个数组中求出全部满足和等于n 的子数组集合
	 */
	public static List<List<Integer>> sumAmountList(int[] nums, int amount){
		return null;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{2,1,7,3,4,5,8};
//		int[] nums = new int[]{2,3,4,6};
		nums=sumAmount(nums, 10);
		IntStream.of(nums).forEach(System.out::print);

	}
}
