package linkedin;

import java.util.*;

public class Solution244 {

    // record all indexs of every word in words
    Map<String, List<Integer>> map = new HashMap<>();
    public Solution244(String[] words) {
        for (int i=0; i<words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    /*public int shortest(String word1, String word2) {

        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (Integer i : word1List) {
            for (Integer j : word2List) {
                min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }*/

    public int shortest(String word1, String word2) {
        List<Integer> loc1, loc2;

        // Location lists for both the words
        // the indices will be in SORTED order by default
        loc1 = this.map.get(word1);
        loc2 = this.map.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        // the module of search shortest distance of two list item.
        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        String[] words = {"practice","makes","perfect","coding","makes"};
        String word1 = "coding";
        String word2 = "practice";
        Solution244 solution244 = new Solution244(words);
        System.out.println(solution244.shortest(word1, word2));
        //["coding","practice"],["makes","coding"]]
    }
}
