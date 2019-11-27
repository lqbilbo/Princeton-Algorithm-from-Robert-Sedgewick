package leetcode;

public class Solution66 {

    private int[] myPlusOne(int[] digits) {
        int digit = 0;
        for (int i=0; i<digits.length; i++) {
            digit += digits[i] * Math.pow(10, digits.length - 1 - i);
        }
        int newDigit = digit + 1;
        int len = (newDigit + "").length();
        int[] ans = new int[len];
        int j = 0;
        while (newDigit != 0) {
            ans[j] = (int) (newDigit / Math.pow(10, len - 1 - j));
            newDigit = (int) (newDigit % Math.pow(10, len - 1 - j));
            j++;
        }
        return ans;
    }

    static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,9};
        int[] ans = plusOne(digits);
        for (int digit : ans) {
            System.out.println(digit);
        }
    }

}
