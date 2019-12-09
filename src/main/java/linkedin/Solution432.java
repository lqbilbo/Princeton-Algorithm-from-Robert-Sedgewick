package linkedin;

import java.util.*;

public class Solution432 {

    Map<String, Node> keyNodeMap;
    DoubleLinkedList ddl;

    /** Initialize your data structure here. */
    public Solution432() {
        keyNodeMap = new HashMap<>();
        ddl = new DoubleLinkedList();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int count = 1;
        Node left = ddl.head;

        // remove the key from original node if exists
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.set.remove(key);
            count = node.count+1;
            if (node.set.isEmpty()) {
                left = node.prev;
                ddl.unlink(node);
            } else {
                left = node;
            }
        }

        // add the key to the new node
        Node right = left.next;
        if (right.count != count) {
            right = new Node(count);
            ddl.appendNode(left, right);
        }
        keyNodeMap.put(key, right);
        right.set.add(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyNodeMap.containsKey(key)) {
            return;
        }

        // remove the key from original node
        Node node = keyNodeMap.get(key);
        node.set.remove(key);
        if (node.set.isEmpty()) {
            ddl.unlink(node);
        }
        keyNodeMap.remove(key);

        // add the key to the new node if count > 1
        if (node.count != 1) {
            Node left = node.prev;
            if (node.prev.count != node.count - 1) {
                left = new Node(node.count - 1);
                ddl.appendNode(node.prev, left);
            }
            keyNodeMap.put(key, left);
            left.set.add(key);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Set<String> set = ddl.tail.prev.set;
        return set.isEmpty() ? "" : set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Set<String> set = ddl.head.next.set;
        return set.isEmpty() ? "" : set.iterator().next();
    }


    class DoubleLinkedList {
        Node head, tail;

        public DoubleLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public void unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void appendNode(Node left, Node right) {
            right.next = left.next;
            right.prev = left;
            left.next = right;
            right.next.prev = right;
        }
    }


    class Node {
        int count;
        Set<String> set;
        Node prev, next;

        public Node(int count) {
            this.count = count;
            this.set = new LinkedHashSet<>();
        }
    }

    public static void main(String[] args) {
        //["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
        //[[],["hello"],["hello"],[],[],["leet"],[],[]]
        Solution432 allOne = new Solution432();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
