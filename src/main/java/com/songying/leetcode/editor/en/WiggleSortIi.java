//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2]
// < nums[3].... 
//
// Example 1: 
//
// 
//Input: nums = [1, 5, 1, 1, 6, 4]
//Output: One possible answer is [1, 4, 1, 5, 1, 6]. 
//
// Example 2: 
//
// 
//Input: nums = [1, 3, 2, 2, 3, 1]
//Output: One possible answer is [2, 3, 1, 3, 1, 2]. 
//
// Note: 
//You may assume all input has valid answer. 
//
// Follow Up: 
//Can you do it in O(n) time and/or in-place with O(1) extra space? Related Topi
//cs Sort


package com.songying.leetcode.editor.en;
public class WiggleSortIi{
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int p = bsSelect(nums, (nums.length - 1) / 2 + 1);
        // Reverse Dutch National Flag with Wiggle Indexing (StefanPochmann's Virtual Indexing).
        // Thanks to apolloydy for reversing this thing.
        final int n = nums.length;
        int m = 0, r = nums.length - 1;
        int lw = 1, mw = 1, rw = (1 + 2 * (nums.length - 1)) % (n | 1);
        while (m <= r) {
            if (nums[mw] > p) {
                int tmp = nums[mw];
                nums[mw] = nums[lw];
                nums[lw] = tmp;
                mw = (mw + 2) % (n | 1);
                ++m;
                lw = (lw + 2) % (n | 1);
            } else if (nums[mw] < p) {
                int tmp = nums[mw];
                nums[mw] = nums[rw];
                nums[rw] = tmp;
                rw = (rw - 2 + (n | 1)) % (n | 1);
                --r;
            } else {
                mw = (mw + 2) % (n | 1);
                ++m;
            }
        }
    }

    private int bsSelect(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("length=" + nums.length + " k=" + k);
        }
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left < 0 && right > 0) ? (left + right) / 2 : left + (right - left) / 2;
            int cl = 0, cg = 0, d = 0;
            for (int n : nums) {
                if (n < mid) {
                    if (++cl > k - 1) {
                        d = +1; // mid larger than kth
                        break;
                    }
                } else if (n > mid) {
                    if (++cg > (nums.length - k)) {
                        d = -1; // mid smaller than kth
                        break;
                    }
                }
            }
            if (d == 0) {
                return mid;
            } else if (d < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new AssertionError();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}