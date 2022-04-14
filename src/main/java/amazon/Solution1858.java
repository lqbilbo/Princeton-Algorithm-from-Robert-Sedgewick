package amazon;

import java.util.Arrays;
import java.util.Comparator;

/***
 * 题目：包含所有前缀的最长单词
 * 描述：给定一个字符串数组words，找出words中所有的前缀都在words中的最长字符串。
 *
 * 例如，令words = ["a", "app", "ap"]。字符串"app"含前缀"ap"和"a"，都在words中。
 * 返回符合上述要求的字符串。如果存在多个（符合条件的）相同长度的字符串，返回字典序中最小的字符串，如果这样的字符串不存在，返回""。
 *
 * 示例1：
 * 输入： words = ["k","ki","kir","kira", "kiran"]
 * 输出： "kiran"
 * 解释： "kiran" 含前缀 "kira"、 "kir"、 "ki"、 和 "k"，这些前缀都出现在 words 中。
 *
 * 示例2：
 * 输入： words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出： "apple"
 * 解释： "apple" 和 "apply" 都在 words 中含有各自的所有前缀。
 * 然而，"apple" 在字典序中更小，所以我们返回之。
 *
 * 示例3：
 * 输入： words = ["abc", "bc", "ab", "qwe"]
 * 输出： ""
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 10^5
 * 1 <= sum(words[i].length) <= 10^5
 *
 */
public class Solution1858 {

    static class Trie {

        TrieNode root;

        static class TrieNode {
            TrieNode[] children;
            boolean isEnd;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length() - 1; i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null || !node.children[idx].isEnd) {
                    return false;
                }
                node = node.children[idx];
            }
            int idx = word.charAt(word.length() - 1) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.isEnd = true;
            return true;
        }
    }

    public static String longestWord(String[] words) {
        String ans = "";
        Trie trie = new Trie();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (trie.insert(word)) {
                int len1 = ans.length();
                int len2 = word.length();
                if (len1 < len2 || ans.compareTo(word) > 0) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words1 = {"k","ki","kir","kira", "kiran"};
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words3 = {"abc", "bc", "ab", "qwe"};
        System.out.println(longestWord(words1));
        System.out.println(longestWord(words2));
        System.out.println(longestWord(words3));
    }
}
