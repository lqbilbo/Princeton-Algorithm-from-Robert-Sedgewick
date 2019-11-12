package leetcode;

import java.util.HashMap;

public class Solution138 {

    /**
     * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},
     * "random":{"$ref":"2"},"val":1}
     */
    private class Node {
        int val;
        Node next;
        Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
