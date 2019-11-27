package leetcode;

public class Solution122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minBuy = prices[0];
        int ans = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                ans += prices[i - 1] - minBuy;
                minBuy = prices[i];
            } else {
                ans += prices[i] - prices[i - 1];
                minBuy = prices[i];
            }
        }
        return ans;
    }

    /**
     * simple one pass
     * @param prices
     * @return
     */
    public int maxProfitSimpleOnePass(int[] prices) {
        if (prices.length == 0) return 0;
        int ans = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

}
