package airbnb;

import java.util.*;

public class Solution336 {

    class TrieNode {
        public int wordEnding = -1; // We'll use -1 to mean there's no word ending here.
        public Map<Character, TrieNode> next = new HashMap<>();
        public List<Integer> palindromePrefixRemaining = new ArrayList<>();
    }

    /**
     * 三种case：
     * 1. Case 1 is where a palindrome pair is formed by 2 words that are the reverse of each other. We'll use the word "BAN" as our example.
     * The reverse of "BAN" is "NAB". Therefore, we need to use our Trie to see if the word "NAB" exists.
     * 2. Case 2 is the one where the first word is shorter than the second word. The second word starts with a palindrome,
     * and ends with the reverse of the first word.
     * 3.Case 3 is the one where the first word is longer than the second word. In terms of our Trie, it would come up where
     * we get to a blue node and still have some letters left from our current word. If those letters that are left form a palindrome,
     * then we have a case 3 palindrome pair. Again, let's look at an example. This time, we are searching for the word "BANANA".
     * Both times we reach a blue node, there is a palindrome remaining.
     *
     * 算法：
     *
     * 我们先创建Trie树。翻转每个单词并标记处它的回文前缀（翻转后的后缀）。将单词放入Trie树中，并标记最后一个放入的单词作为终止结点，包含单词的索引。
     * 而且，插入的同事，注意在添加的列表中的任何点，单词的剩余部分都是包含有索引的回文后缀。
     *
     * Then, we go back through the list of words, looking each up in the Trie. Any of the following situations give us palindrome pairs.
     * 然后我们回溯列表中的所有单词，在Trie查找相应的位置。 下面每种情况都是一个回文对。
     * We have no letters left on the word and are at a word end node (case 1).
     * 自己本身就是一个回文
     * We have no letters left on the word and there are indexes in the list attached to the node (case 2).
     * 右边的单词包含有回文的前缀和左边单词的翻转
     * We have a palindrome left on the word and are on a word end node (case 3).
     * 左边的单词包含回文的后缀且和右边的单词的翻转
     * Time Complexity : O(k^2 * n).
     * Space Complexity : O((k + n)^2)
     */
    class Solution {

        // Is the given string a palindrome after index i?
        // Tip: Leave this as a method stub in an interview unless you have time
        // or the interviewer tells you to write it. The Trie itself should be
        // the main focus of your time.
        public boolean hasPalindromeRemaining(String s, int i) {
            int p1 = i;
            int p2 = s.length() - 1;
            while (p1 < p2) {
                if (s.charAt(p1) != s.charAt(p2)) return false;
                p1++; p2--;
            }
            return true;
        }

        public List<List<Integer>> palindromePairs(String[] words) {

            TrieNode trie = new TrieNode();

            // Build the Trie
            for (int wordId = 0; wordId < words.length; wordId++) {
                String word = words[wordId];
                String reversedWord = new StringBuilder(word).reverse().toString();
                TrieNode currentTrieLevel = trie;
                for (int j = 0; j < word.length(); j++) {
                    if (hasPalindromeRemaining(reversedWord, j)) {
                        currentTrieLevel.palindromePrefixRemaining.add(wordId);
                    }
                    Character c = reversedWord.charAt(j);
                    if (!currentTrieLevel.next.containsKey(c)) {
                        currentTrieLevel.next.put(c, new TrieNode());
                    }
                    currentTrieLevel = currentTrieLevel.next.get(c);
                }
                currentTrieLevel.wordEnding = wordId;
            }

            // Find pairs
            List<List<Integer>> pairs = new ArrayList<>();
            for (int wordId = 0; wordId < words.length; wordId++) {
                String word = words[wordId];
                TrieNode currentTrieLevel = trie;
                for (int j = 0; j < word.length(); j++) {
                    // Check for pairs of case 3.
                    if (currentTrieLevel.wordEnding != -1
                            && hasPalindromeRemaining(word, j)) {
                        pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
                    }
                    // Move down to the next trie level.
                    Character c = word.charAt(j);
                    currentTrieLevel = currentTrieLevel.next.get(c);
                    if (currentTrieLevel == null) break;
                }
                if (currentTrieLevel == null) continue;
                // Check for pairs of case 1. Note the check to prevent non distinct pairs.
                if (currentTrieLevel.wordEnding != -1 && currentTrieLevel.wordEnding != wordId) {
                    pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
                }
                // Check for pairs of case 2.
                for (int other : currentTrieLevel.palindromePrefixRemaining) {
                    pairs.add(Arrays.asList(wordId, other));
                }
            }

            return pairs;
        }
    }
}
