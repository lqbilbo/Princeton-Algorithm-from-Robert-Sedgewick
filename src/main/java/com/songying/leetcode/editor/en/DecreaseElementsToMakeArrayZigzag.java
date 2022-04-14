//Given an array nums of integers, a move consists of choosing any element and d
//ecreasing it by 1. 
//
// An array A is a zigzag array if either: 
//
// 
// Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1]
// < A[2] > A[3] < A[4] > ... 
// OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A
//[1] > A[2] < A[3] > A[4] < ... 
// 
//
// Return the minimum number of moves to transform the given array nums into a z
//igzag array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 2
//Explanation: We can decrease 2 to 0 or 3 to 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [9,6,1,6,2]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics Array


package com.songying.leetcode.editor.en;
public class DecreaseElementsToMakeArrayZigzag{
    public static void main(String[] args) {
        Solution solution = new DecreaseElementsToMakeArrayZigzag().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movesToMakeZigzag(int[] A) {
        int res[] = new int[2],  n = A.length, left, right;
        for (int i = 0; i < n; ++i) {
            left = i > 0 ? A[i - 1] : 1001;
            right = i + 1 < n ? A[i + 1] : 1001;
            res[i % 2] += Math.max(0, A[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}