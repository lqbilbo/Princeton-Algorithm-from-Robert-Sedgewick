package topic.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

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
