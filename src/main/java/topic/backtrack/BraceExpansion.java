package topic.backtrack;

import java.util.TreeSet;

public class BraceExpansion {

    public String[] expand(String S) {
        // TreeSet to sort
        TreeSet<String> set = new TreeSet<>();
        if (S.length() == 0) {
            return new String[]{""};
        } else if (S.length() == 1) {
            return new String[]{S};
        }
        if (S.charAt(0) == '{') {
            int i = 0; // keep track of content in the "{content}"
            while (S.charAt(i) != '}') {
                i++;
            }
            String sub = S.substring(1, i);
            String[] subs = sub.split(",");
            String[] strs = expand(S.substring(i + 1)); // dfs
            for (int j = 0; j < subs.length; j++) {
                for (String str : strs) {
                    set.add(subs[j] + str);
                }
            }
        } else {
            String[] strs = expand(S.substring(1));
            for (String str : strs) {
                set.add(S.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }
}
