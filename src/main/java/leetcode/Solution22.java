package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    /**
     * Intuition
     *
     * To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.
     *
     * Consider the closure number of a valid parentheses sequence S: the least index >= 0 so that S[0], S[1], ...,
     * S[2*index+1] is valid. Clearly, every parentheses sequence has a unique closure number. We can try to enumerate
     * them individually.
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generateParenthesis(c)) {
                    for (String right: generateParenthesis(n-1-c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Intuition:
     * let's only add them when we know it will remain a valid sequence. We can do this by keeping track of the number
     * of opening and closing brackets we have placed so far.
     *
     * We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if
     * it would not exceed the number of opening brackets.
     * @param n
     * @return
     */
    public List<String> generateParenthesisWithBackTracking(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
