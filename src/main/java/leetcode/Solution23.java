package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution23 {

    /**
     * merge two linked list model
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }

    /**
     * Time complexity : O(Nlogk) where k is the number of linked lists.
     *
     * Space complexity : O(1)
     * We can merge two sorted linked lists in O(1) space.
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return lists[0];
    }

    /**
     * use priority queue
     * Time complexity : O(Nlogk)
     * Space complexity : O(N+k) ~ O(N)
     * @param lists
     * @return
     */
    public ListNode mergeKListsWithPriorityQueue(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }
}
