package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public static String longestPalindrme2(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        String finalStr = "";
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            String longestStr = "" + str[i];
            hashMap.put(str[i], i);
            for (int j = i+1; j < str.length; j++) {
                if (hashMap.containsKey(str[j])) {
                    longestStr += str[j];
                    if (longestStr.length() > max) {
                        max = longestStr.length();
                        finalStr = longestStr;
                    }
                    break;
                } else {
                    hashMap.put(str[j], j);
                    longestStr += str[j];
                }
            }
        }
        return finalStr;
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "baabd";
        String result = longestPalindrome1(s);
        System.out.println(result);
    }
}
