package javacode.dynamicprogramming;

/**
 * 64. Minimum Path Sum
 *
 *	Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for(int i=1; i<m; i++){
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}
		for(int j=1; j<n; j++){
			dp[0][j] = grid[0][j] + dp[0][j-1];
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(dp[i-1][j] <= dp[i][j-1]){
					dp[i][j] = dp[i-1][j] + grid[i][j];
				} else {
					dp[i][j] = dp[i][j-1] + grid[i][j];
				}
			}
		}
		return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		MinimumPathSum path = new MinimumPathSum();
		int[] row1 = {1,2};
		int[] row2 = {1,3};
//		int[] row3 = {4,2,1};
		int[][] grid = {row1};
		System.out.println(path.minPathSum(grid));

	}

}
