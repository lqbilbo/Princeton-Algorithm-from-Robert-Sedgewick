package leetcode;

public class Solution148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)  return head;
        ListNode dnode = new ListNode(-1);
        dnode.next = head;
        ListNode p = dnode;
        ListNode q = dnode;
        // q will be the middle end
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }
        ListNode sec_head = q.next;
        q.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(sec_head);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dnode = new ListNode(-1);
        ListNode head = dnode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return dnode.next;
    }
}
