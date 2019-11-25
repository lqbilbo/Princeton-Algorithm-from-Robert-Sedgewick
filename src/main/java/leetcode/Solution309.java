package leetcode;

public class Solution309 {

    public static int maxProfit(int[] prices) {

        int buy=Integer.MAX_VALUE;
        int noBuy=0;
        int sell=0;
        for (int i=0; i<prices.length; i++) {
            buy = Math.min(buy, prices[i] - noBuy);
            noBuy = Math.max(noBuy, sell);
            sell = Math.max(sell, prices[i] - buy);
        }

        return Math.max(sell,noBuy);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
