//Given an array of strings arr. String s is a concatenation of a sub-sequence o
//f arr which have unique characters. 
//
// Return the maximum possible length of s. 
//
// 
// Example 1: 
//
// 
//Input: arr = ["un","iq","ue"]
//Output: 4
//Explanation: All possible concatenations are "","un","iq","ue","uniq" and "iqu
//e".
//Maximum length is 4.
// 
//
// Example 2: 
//
// 
//Input: arr = ["cha","r","act","ers"]
//Output: 6
//Explanation: Possible solutions are "chaers" and "acters".
// 
//
// Example 3: 
//
// 
//Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
//Output: 26
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] contains only lower case English letters. 
// 
// Related Topics Backtracking Bit Manipulation


package com.songying.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max = 0;

    public void dfs(List<String> strList, List<Integer> flagList, int index, int flag, int length) {
        max = Math.max(max, length);
        if (index >= strList.size())
            return;
        for (int i = index; i < flagList.size(); i++) {
            if ((flagList.get(i) & flag) == 0) { // judge whether string sequence contains duplicate char via bit manipulation
                dfs(strList, flagList, i + 1, flagList.get(i) | flag, length + strList.get(i).length());
            }
        }
    }

    /**
     * time: 2ms
     * memory: 34.2m
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        List<String> strList = new ArrayList<String>();
        List<Integer> flagList = new ArrayList<Integer>();
        // 1. preprocess the list
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);
            boolean temp[] = new boolean[26];
            boolean valid = true;
            for (int j = 0; j < str.length(); j++) {
                if (temp[str.charAt(j) - 'a']) {
                    valid = false;
                    break;
                }
                temp[str.charAt(j) - 'a'] = true;
            }
            if (!valid) // eliminate strings that contain duplicate char
                continue;
            int flag = 0;
            for (int j = 0; j < 26; j++) { // record chars contained in a string
                flag |= (temp[j] ? (1 << j) : 0);
            }
            strList.add(str);
            flagList.add(flag);
        }
        dfs(strList, flagList, 0, 0, 0);
        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}