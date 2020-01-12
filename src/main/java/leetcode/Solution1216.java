package leetcode;

public class Solution1216 {

    /**
     * 使用二阶数组用于做DP，[i][j]的值表示移除一定位数后得到回文所用的最小的步数。
     * 对于每个[i][j]有两个场景：
     * s.charAt(i) == s.charAt(j) then cache[i][j] = cache[i+1][j-1]
     * s.charAt(i) != s.charAt(j) then cache[i][j] = 1 + Math.min(cache[i+1][j], cache[i][j-1)
     * @param s
     * @param k
     * @return
     */
    public boolean isValidPalindrome(String s, int k) {
        Integer[][] cache = new Integer[s.length()][s.length()];
        return aux(s, 0, s.length()-1, cache) <= k;
    }

    private int aux(String s, int left, int right, Integer[][] cache) {
        if (right - left < 1) return 0;
        if (cache[left][right] != null) return cache[left][right];

        int step = 0;
        if (s.charAt(left) == s.charAt(right)) {
            step = aux(s, left+1, right-1, cache);
        } else {
            step = 1 + Math.min(aux(s, left+1, right, cache), aux(s, left, right-1, cache));
        }
        cache[left][right] = step;
        return step;
    }

    public static void main(String[] args) {
        String s = "abcdeca";
        int k = 2;
        Solution1216 solution1216 = new Solution1216();
        System.out.println(solution1216.isValidPalindrome(s, k));
    }
}
