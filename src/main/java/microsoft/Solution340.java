package microsoft;

public class Solution340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // 这道题很关键的在于，要longest的题好像用右指针当主指针比较合适

        int[] count = new int[256];
        char[] str = s.toCharArray();
        int maxLen = 0;
        int currentK = 0;

        for (int l = 0, r = 0; r < str.length; r++) {
            count[str[r]]++;
            if (count[str[r]] == 1) {
                currentK++;
            }
            if (currentK == k + 1) {
                // move left pointer so that currentK became k
                while (l < str.length) {
                    count[str[l]]--;
                    l++;
                    if (count[str[l - 1]] == 0) {
                        currentK--;
                        break;
                    }
                }
            }
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
            }

        }
        return maxLen;

    }
}
