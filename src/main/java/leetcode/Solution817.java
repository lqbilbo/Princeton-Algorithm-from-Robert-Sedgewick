package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution817 {

    /**
     * Time Complexity: O(N + G.length), where NN is the length of the linked list with
     * root node head.
     * Space Complexity: O(G.length), to store Gset.
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet<>();
        for (int x: G) Gset.add(x);

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }
}
