package microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    /**
     * Level Order Traversal
     * TP: O(N)
     * SP: O(N)
     * @param root
     * @return
     */
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        while (Q.size() > 0) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        return root;

    }


    Node prev, leftmost;

    public void processChild(Node childNode) {
        if (childNode != null) {

            if (this.prev != null) {
                this.prev.next = childNode;
            } else {
                this.leftmost = childNode;
            }

            this.prev = childNode;
        }
    }

    /**
     * Using previously established next pointers
     * TP: O(N)
     * SP: O(1)
     * @param root
     * @return
     */
    public Node connectUsingPrev(Node root) {

        if (root == null) {
            return root;
        }

        this.leftmost = root;
        Node curr = leftmost;

        while (this.leftmost != null) {
            this.prev = null;
            curr = this.leftmost;

            this.leftmost = null;

            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }

        return root;
    }
}
