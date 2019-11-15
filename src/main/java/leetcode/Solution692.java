package leetcode;

import java.util.*;

/**
 * Recommand use Heap to solve top k problem
 */
public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], 0);
            map.put(words[i], map.get(words[i]) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getKey());

        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }

    /* ************************************ Heap **************************************/

    public List<String> topKFrequent3(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        Solution692 solution692 = new Solution692();

        List<String> strings = solution692.topKFrequent3(words, k);
        for (String str : strings) {
            System.out.println(str + ",");
        }
    }

}
