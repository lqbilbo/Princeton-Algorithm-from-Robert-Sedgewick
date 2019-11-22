package amazon;

import java.util.Stack;

public class Solution8 {

    public int myAtoi(String str) {
        int ans = 0;
        Stack<Integer> ansStack = new Stack<Integer>();
        int minusFlag = 0;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isWhitespace(charArr[i])) {
                continue;
            }
            if (Character.isLetter(charArr[i])) {
                break;
            }
            if (i == 0 && String.valueOf(charArr[i]).equals('-')) {
                minusFlag = 1;
                continue;
            }
            if (Character.isDigit(charArr[i])) {
                ansStack.push(Integer.valueOf(charArr[i]));
            }
        }
        if (ansStack.isEmpty()) {
            return 0;
        } else {
            int bit = 1;
            while (!ansStack.isEmpty()) {
                ans += ansStack.pop() * bit;
                bit = bit * 10;
            }
        }
        if (ans != 0 && ans <= Integer.MAX_VALUE && ans >= Integer.MIN_VALUE) {
            if (minusFlag == 0) {
                return ans;
            } else {
                return 0 - ans;
            }
        } else if (ans >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return ans;
    }
}
