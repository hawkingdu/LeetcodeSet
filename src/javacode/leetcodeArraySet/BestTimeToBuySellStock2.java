package javacode.leetcodeArraySet;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 
 *	Input: [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
             
   	Input: [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
 */
public class BestTimeToBuySellStock2 {

	/**
	 * Complexity O(n)
	 * 
	 */
	public int maxProfit(int[] prices) {
        int max=0;
        if(prices.length>1){
        	int buy=prices[0], profit=0;
        	for(int i=1; i<prices.length; i++){
        		if(prices[i]-buy <profit){
        			buy=prices[i];
        			max += profit;
        			profit = 0;
        		} else {
        			profit= prices[i]-buy;
        		}
        	}
        	max += profit;
        }
        return max;
    }
	public static void main(String[] args) {
		BestTimeToBuySellStock2 buySell = new BestTimeToBuySellStock2();
		int[] prices = {1,1};
		System.out.println(buySell.maxProfit(prices));
	}

}
