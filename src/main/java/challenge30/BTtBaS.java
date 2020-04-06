package challenge30;

public class BTtBaS {
    public int maxProfit(int[] prices) {
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
