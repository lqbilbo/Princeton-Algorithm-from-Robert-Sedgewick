package leetcode;

import java.util.Stack;

public class Solution369 {

    public static ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        Stack<Integer> inverseStack = new Stack<>();
        int isDescend = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                isDescend = reverse(stack, inverseStack);
            } else {
                if (isDescend == 1) {
                    isDescend = reverse(stack, inverseStack);
                } else {
                    inverseStack.push(stack.pop());
                }
            }
        }
        ListNode ans = new ListNode(inverseStack.pop());
        while (!inverseStack.isEmpty()) {
            ListNode listNode = new ListNode(inverseStack.pop());
            ans.next = listNode;
            ans = listNode;
        }
        return ans;
    }

    private static int reverse(Stack<Integer> stack, Stack<Integer> inverseStack) {
        int isDescend;
        int lastDigit = stack.pop() + 1;
        isDescend = 0;
        if (lastDigit >= 10) {
            lastDigit = lastDigit % 10;
            inverseStack.push(lastDigit);
            isDescend = 1;
        } else {
            inverseStack.push(lastDigit);
        }
        return isDescend;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(plusOne(head));
    }

    public ListNode plusOneW(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }

        if (dummy.val == 0) {
            return dummy.next;
        }

        return dummy;
    }

}
