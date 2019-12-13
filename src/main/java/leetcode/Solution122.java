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
     * Peak Valley Approach
     * The key point is we need to consider every peak immediately following a valley to maximize the profit.
     * In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the
     * transactions leading to an overall lesser profit.
     *
     * 我们应该关注紧挨着谷值之后的那个峰值，如果错过了一个峰值，那么最终整体的收益会低于包含每个峰值的收益，
     * 有点像贪心算法，求到局部最优解，最后才能得到接近全局最优解的值。
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param prices
     * @return
     */
    public int maxProfitWithPeakValleyApproach(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * Simple One Pass
     * In this case, instead of looking for every peak following a valley, we can simply go on crawling over the slope
     * and keep on adding the profit obtained from every consecutive transaction.
     * we can directly keep on adding the difference between the consecutive numbers of the array if the second number
     * is larger than the first one, and at the total sum we obtain will be the maximum profit. This approach will
     * simplify the solution.
     *
     * 不用关心每个谷值和峰值，只要简单地爬取所有的间隔进程，然后将每个进程的收益加起来。
     * 只要第二个数字大于前面的，就相减并累加最终的收益
     * Time Complexity: O(n)
     * Space Complexity: O(1)
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
