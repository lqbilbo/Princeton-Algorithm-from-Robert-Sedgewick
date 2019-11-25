package amazon;

import java.util.Stack;

public class Atoi {

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

    public int myAtoi2(String str) {
        int value = 0;
        if (str == null) {
            return value;
        }
        int length = str.length();
        int sign = 1;
        boolean started = false;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && !started) {
                continue;
            } else if (c == '-' && !started) {
                sign = -1;
                started = true;
                continue;
            } else if (c == '+' && !started) {
                started = true;
                continue;
            } else if (c >= '0' && c <= '9') {
                started = true;
                if (multiplyOverflows(value, sign)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                value *= 10;
                int digit = c - '0';
                if (additionOverflows(value, digit, sign)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                value += digit;
                continue;
            } else {
                break;
            }
        }
        return value * sign;
    }

    private boolean multiplyOverflows(int valueSoFar, int sign) {
        if (sign == 1) {
            return Integer.MAX_VALUE / 10 < valueSoFar;
        } else {
            return Integer.MIN_VALUE / 10 > valueSoFar * -1;
        }
    }

    private boolean additionOverflows(int valueSoFar, int digit, int sign) {
        if (sign == 1) {
            return Integer.MAX_VALUE - digit < valueSoFar;
        } else {
            return Integer.MIN_VALUE + digit > valueSoFar * -1;
        }
    }
}
