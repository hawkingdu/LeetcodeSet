package javacode.leetcodeArraySet;

public class BestTimeToBuySellStock {

	public int maxProfit(int[] prices) {
		int maxProfit = 0, buy = 0, sell=0;
		for(int i=0; i<prices.length-1; i++){
			buy = prices[i];
			for(int j=i+1;j<prices.length; j++){
				sell = prices[j];
				if(sell - buy >0){
					maxProfit = Math.max(maxProfit, sell - buy);
				}
			}
		}
		return maxProfit;
    }
	
	public int maxProfit2(int[] prices){
		int maxProfit=0, sell=0;
		if(prices.length>0){
			int low=prices[0];
			for(int i=1; i<prices.length; i++){
				sell = prices[i];
				maxProfit = Math.max(maxProfit, sell-low);
				low = Math.min(low, sell);
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		BestTimeToBuySellStock buySell = new BestTimeToBuySellStock();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(buySell.maxProfit2(prices));

	}

}
