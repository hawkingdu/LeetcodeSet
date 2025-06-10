package javacode.dynamicprogramming;

public class BagAlgorithm {

	public static void main(String[] args) {
		int[] values = new int[]{12,26,23,11,18,22};
		int[] weight = new int[]{4 ,7 ,1 ,9 ,6 ,5 };
		int capacity = 10;
		zeroOneBag(weight, values, capacity);
	}
	
	public static void zeroOneBag(int[] weight, int[] values, int capacity){
		int num;
		if (weight.length != values.length) {
			System.out.println("参数错误，重量数组和价值数组数量不匹配！退出程序");
			return;
		} else {
			num = weight.length;
		}

		int[][] dp = new int[num+1][capacity+1]; //定义DP状态，初始化DP，+1是为了增加数字0列
		//定义状态dp[i][j] 表示前i个物品在容量为j的条件下可以得到的最大值
		//状态转移：
		// 如果 当前物品重量weight[i] 大于 当前容量j ，不能放入背包，所以 dp[i][j] = dp[i-1][j]，即不放入该物品时的最大值
		// 否则 当前物品重量weight[i] 小于等于 当前容量j，考虑是否值得放入背包
		// 		1. 放入：dp[i][j] = dp[i-1][j - weight[i]] + value[i]
		//		2. 不放入：dp[i][j] = dp[i-1][j]
		int[] weight_real = new int[weight.length];
		int itemnum=0;
		for(int i=1; i <=num; i++){
			for(int j=1; j<=capacity; j++){
				if (weight[i - 1] <= j) { // 如果当前物品小于等于总容量，可以考虑放进背包
					if (dp[i - 1][j - weight[i - 1]] + values[i - 1] > dp[i - 1][j]) {
						dp[i][j] = dp[i - 1][j - weight[i - 1]] + values[i - 1];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
//					dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + values[i - 1] , dp[i - 1][j]);
				} else { // 如果当前物品大于总容量，不考虑放进背包，直接取前i个物品的最大值
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
				
		System.out.println(dp[num][capacity]);

		
		for(int i=0; i<weight_real.length; i++){
			System.out.print(weight_real[i]+",");
		}
	}

}
