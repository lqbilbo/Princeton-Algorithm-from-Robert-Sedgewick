//Given a non-empty array of digits representing a non-negative integer, plus on
//e to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array


package com.songying.leetcode.editor.en;
public class PlusOne{
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}