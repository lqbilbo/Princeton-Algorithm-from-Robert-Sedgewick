package common;

import leetcode.ListNode;

import java.util.LinkedList;

public class LinkedListToListNode {

    public static ListNode convert(LinkedList<Integer> linkedList) {

        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (!linkedList.isEmpty()) {
            p.next = new ListNode(linkedList.pop());
            p = p.next;
        }
        return head.next;
    }
}
