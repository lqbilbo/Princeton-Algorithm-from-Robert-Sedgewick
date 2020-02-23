//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


package com.songying.leetcode.editor.en;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        solution.groupAnagrams(strs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map= new HashMap<>();
        int[] counter = new int[26];
        for (String str : strs) {
            Arrays.fill(counter, 0);
            for (char c : str.toCharArray()) counter[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // divide each chars
                sb.append('#');
                sb.append(counter[i]);
            }
            String key = sb.toString();
            // insert into bins, same group must be in the same bin
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}