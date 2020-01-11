package airbnb;

public class Solution875 {

    /**
     * 直觉和算法
     *
     * 如果我们让possible(K)为true，那么肯定存在着X，使得K >= X。最慢的速度是X，最快K
     *
     * 我们将通过二分查找找到使得possible(K)成立的最小K。其中每组时间取值为 time = (p - 1) / K + 1。（等价于向上取整Math.ceil(p / K)）
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }

    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles) {
            time += (p-1) / K + 1;
        }
        return time <= H;
    }
}
