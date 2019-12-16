package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */

import learn.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 *
 * intuition:
 * 1.In order
 * 2.Pre order and
 * 3.Post order traversals
 */
public class Solution109 {

    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        // Invalid case
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // First step of simulated inorder traversal. Recursively form
        // the left half
        TreeNode left = this.convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;

        // Maintain the invariance mentioned in the algorithm
        this.head = this.head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }

    /**
     * Inorder Simulation
     * Intuition:
     * Elements processed in the inorder fashion on a binary search tree turn out to be sorted in ascending order.
     * We know that the leftmost element in the inorder traversal has to be the head of our given linked list. Similarly,
     * the next element in the inorder traversal will be the second element in the linked list and so on. This is made
     * possible because the initial list given to us is sorted in ascending order.
     * Time Complexity: O(N)
     * Space Complexity: O(logN)
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // Get the size of the linked list first
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }
}