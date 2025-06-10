package javacode.dynamicprogramming;

/**
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 	Example 1:
	Input: m = 3, n = 2
	Output: 3
	Explanation:
	From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	1. Right -> Right -> Down
	2. Right -> Down -> Right
	3. Down -> Right -> Right
	
	Example 2:
	Input: m = 7, n = 3
	Output: 28
 */
public class UniquePaths {
	
	/**
	 * 1. define two-dimension array to record path nums
	 * 2. each bottom-right cell equal left + up
	 * 3. last cell is final path number
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];  // 定义状态，每个格子存放当前路径数

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				/**
				 * 状态转移
				 * 当前路径等于 左边路径 + 上边路径
				 */
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(6, 3));
	}
}
