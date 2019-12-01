package linkedin;

import java.util.ArrayList;
import java.util.List;

public class Solution243 {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int len = words.length;
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        for (int i=0; i<len; i++) {
            int k = 0, m = 0;
            if (words[i].equals(word1)) {
                index1.add(i);
                k++;
            }
            if (words[i].equals(word2)) {
                index2.add(i);
                m++;
            }
        }
        int minDistance = Math.abs(index1.get(0) - index2.get(0));
        for (int i=0;i<index1.size();i++) {
            for (int j=0;j<index2.size();j++) {
                int distance = Math.abs(index1.get(i) - index2.get(j));
                if (distance <= minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b"};
        String word1 = "a";
        String word2 = "b";
        System.out.println(shortestDistance(words, word1, word2));
    }

    public int shortestDistanceWithOnePass(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}
