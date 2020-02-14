package topic.linkedlist;

import leetcode.ListNode;

public class ReverseLinkedList {

    /**
     * 使用哨兵辅助
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 不使用哨兵节点，直接用null
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
