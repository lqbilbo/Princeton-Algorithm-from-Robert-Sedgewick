package amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/***
 * 题目：至多包含两个不同字符的最长子串
 * 描述：给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 *
 * 示例1：
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 *
 * 示例2：
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class Solution159 {

    public static int lengthOfLongestSubstringTwoDistinct2(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        int left = 0, right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right++);
            }
            if (map.size() == 3) {
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int left = 0, right = 0;
        for (int types = 0; right < s.length();) {
            if (count[s.charAt(right++)]++ == 0) {
                ++types;
            }
            if (types > 2) {
                if (--count[s.charAt(left++)] == 0) {
                    --types;
                }
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        String s1 = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct2(s1));
        String s2 = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct2(s2));
    }
}
