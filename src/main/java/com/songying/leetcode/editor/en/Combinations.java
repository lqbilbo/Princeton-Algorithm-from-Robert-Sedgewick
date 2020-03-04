//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking


package com.songying.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), k, 1, n-k+1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int kLeft, int from, int to) {
        if (kLeft == 0) {
            ans.add(new ArrayList<>(list)); return;
        }
        for (int i = from; i <= to; i++) {
            list.add(i);
            dfs(ans, list, kLeft - 1, i + 1, to + 1);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}