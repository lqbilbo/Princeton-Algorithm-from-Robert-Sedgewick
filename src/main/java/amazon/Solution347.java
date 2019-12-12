package amazon;

import java.util.*;

public class Solution347 {

    /**
     * intuition
     * Count the frequency of each word, then add it to heap that stores the best k candidates. Here, "best" is defined
     * with our custom ordering relation, which puts the worst candidates at the top of the heap. At the end, we pop off
     * the heap up to k times and reverse the result so that the best candidates are first.
     *
     * Time Complexity: O(N \log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in
     * O(N)O(N) time, then we add NN words to the heap, each in O(\log {k})O(logk) time. Finally, we pop from the heap
     * up to kk times. As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total.
     *
     * Space Complexity: O(N)O(N), the space used to store our count.
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentWithHeap(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
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

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    /**
     * intuition
     * Count the frequency of each word, and sort the words with a
     * custom ordering relation that uses these frequencies. Then take the best k of them.
     *
     * Time Complexity: O(N \log{N})O(NlogN), where NN is the length of words.
     * We count the frequency of each word in O(N)O(N) time, then we sort the given words
     * in O(N \log{N})O(NlogN) time.
     *
     * Space Complexity: O(N)O(N), the space used to store our candidates.
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentWithSort(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
}
