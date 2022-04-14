package amazon;

import java.util.Arrays;

/***
 * 题目：最长公共前缀
 * 描述：编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length() && i < strs[strs.length - 1].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }
}
