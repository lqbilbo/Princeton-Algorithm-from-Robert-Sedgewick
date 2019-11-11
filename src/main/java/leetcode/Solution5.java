package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public static String longestPalindrme(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        String longestStr = "";
        String finalStr = "";
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if (hashMap.containsKey(str[i])) {
                    longestStr += str[i];
                    if (longestStr.length() > max) {
                        max = longestStr.length();
                        finalStr = longestStr;
                    }
                    continue;
                } else {
                    hashMap.put(str[i], i);
                    longestStr += str[i];
                }
            }
        }
        return finalStr;
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrme(s);
        System.out.println(result);
    }
}
