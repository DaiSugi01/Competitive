package LeetCode.DP;

public class BestTimeBuySellStock_121 {

    /*
        Input: prices = [7,1,5,3,6,4]
        Output: 5

        highestPrice = 5;
        lowestPrice = 1;
        maxProfit = 0;

        if the current price(prices[i]) is lower than the lowest price
            update the lowest price to current price
            update the highest price to current price
        else
            update the highest price to current price
            maxProfit = max(maxProfit, highest price - lowest price)
     */
    public int maxProfit(int[] prices) {
        int highestPrice = prices[0];
        int lowestPrice = prices[0];
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
