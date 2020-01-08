//Koko loves to eat bananas. There are N piles of bananas, the i-th pile has pil
//es[i] bananas. The guards have gone and will come back in H hours. 
//
// Koko can decide her bananas-per-hour eating speed of K. Each hour, she choose
//s some pile of bananas, and eats K bananas from that pile. If the pile has less 
//than K bananas, she eats all of them instead, and won't eat any more bananas dur
//ing this hour. 
//
// Koko likes to eat slowly, but still wants to finish eating all the bananas be
//fore the guards come back. 
//
// Return the minimum integer K such that she can eat all the bananas within H h
//ours. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], H = 8
//Output: 4
// 
//
// 
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], H = 5
//Output: 30
// 
//
// 
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], H = 6
//Output: 23
// 
//
// 
//
// Note: 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// 
// 
// 
// Related Topics Binary Search


package com.songying.leetcode.editor.en;
public class KokoEatingBananas{
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}