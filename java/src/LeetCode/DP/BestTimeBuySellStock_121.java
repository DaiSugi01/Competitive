package LeetCode.DP;

public class BestTimeBuySellStock_121 {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int highestPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (lowestPrice > prices[i]) {
                lowestPrice = prices[i];
            } else {
                highestPrice = prices[i];
                maxProfit = Math.max(maxProfit, highestPrice - lowestPrice);
            }
        }
        return maxProfit;
    }
}
