//Given two integers representing the numerator and denominator of a fraction, r
//eturn the fraction in string format. 
//
// If the fractional part is repeating, enclose the repeating part in parenthese
//s. 
//
// Example 1: 
//
// 
//Input: numerator = 1, denominator = 2
//Output: "0.5"
// 
//
// Example 2: 
//
// 
//Input: numerator = 2, denominator = 1
//Output: "2" 
//
// Example 3: 
//
// 
//Input: numerator = 2, denominator = 3
//Output: "0.(6)"
// 
// Related Topics Hash Table Math


package com.songying.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}