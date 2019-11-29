package leetcode;

public class Solution328 {

    /**
     * The best way of solving any linked list problem is to visualize it either in your mind or on a piece of paper.
     *
     * intuition:
     * Put the odd nodes in a linked list and the even nodes in another.
     * Then link the evenList to the tail of the oddList.
     *
     * Time complexity : O(n)O(n). There are total nn nodes and we visit each node once.
     * Space complexity : O(1)O(1). All we need is the four pointers.
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        oddEvenList(head);
    }
}
