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
}
