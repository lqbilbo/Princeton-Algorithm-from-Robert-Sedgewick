package leetcode;

public class Solution121 {

    /**
     * intuition
     * The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following
     * the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley
     * and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxSell = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else if (prices[i] - minBuy > maxSell) {
                maxSell = prices[i] - minBuy;
            }
        }
        return maxSell;
    }
}
