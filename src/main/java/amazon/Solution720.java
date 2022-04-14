package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution720 {

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words1 = {"w","wo","wor","worl","world"};
        String[] words2 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words1));
        System.out.println(longestWord(words2));
    }
}
