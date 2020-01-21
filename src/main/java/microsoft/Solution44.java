package microsoft;

public class Solution44 {

    /**
     * 使用双指针: s_idx来遍历字符串，p_idx来遍历模式串
     * 当s_idx < s_len时，
     * 1. 如果存在p_idx < p_len使得p[p_idx] = s[s_idx]或者p[p_idx] = ?那么分别往前移动两个指针。
     * 2. 如果依旧存在p_idx < p_len而且p[p_idx] = *，那么增加p_idx，记录下*的位置star_idx和当前字符串指针位置s_tmp_idx
     *
     * 如果当不满足p_idx < p_len时，
     * 1. 如果star_idx = 0，那么返回false。
     * 2. 如果star_idx != 0，那么设置p_idx = star_idx + 1，s_idx = s_tmp_idx + 1.加入*只匹配到一个字符，当前的变量
     * s_tmp_idx = s_idx。
     *
     * 返回true如果模式串中只有*
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // If the pattern caracter = string character
            // or pattern character = '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                ++sIdx;
                ++pIdx;
            }
            // If pattern character = '*'
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern
            else if (starIdx == -1) {
                return false;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for(int i = pIdx; i < pLen; i++)
            if (p.charAt(i) != '*') return false;
        return true;
    }
}
