package amazon;

import java.util.HashMap;

/**
 * 克隆逻辑：如果访问哈希map包含节点则直接返回；否则deepcopy一个并返回
 * 思路：先做老结点的浅拷贝（只拷贝值），再做新老结点的映射。克隆
 */
public class CopyListWithRandomPointer {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    HashMap<Node, Node> visited = new HashMap<>();

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);

    }
}
