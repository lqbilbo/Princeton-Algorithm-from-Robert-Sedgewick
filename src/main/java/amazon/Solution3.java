package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 题目：返回一个字符串中最长无重复字符的子串的长度
 * 描述：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 提示：
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 */
public class Solution3 {

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];  // ASCII码的字母域长度为128
        Arrays.fill(last, -1);

        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s1));
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring2(s2));
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s3));
    }
}
