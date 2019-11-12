package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    private static Map<Integer, Map<Integer, Integer>> lruCache = new HashMap<>();
    private static Map<Integer, Integer> finalMap = new HashMap<>();
    private int _capacity;
    private int count = 0;
    private int remove = 0;

    public Solution146(int capacity) {
        _capacity = capacity;
    }

    public int get(int key) {
        return finalMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(key, value);
        finalMap.putAll(tmp);
        if (lruCache.isEmpty()) {
            count++;
            lruCache.put(count, tmp);
        } else {
            if (count == _capacity) {
                Map<Integer, Integer> lastTmp = lruCache.get(count - remove);
//                finalMap(lastTmp);
                lruCache.remove(count-remove);
                lruCache.put(count-remove+1, tmp);
                remove += 1;
            } else {
                count++;
                lruCache.put(count, tmp);
            }
        }
    }

    /* ******************************Solution: HashMap + DoubleLinkedList *********************/
    class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            /**
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node){
            /**
             * Remove an existing node from the linked list.
             */
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node){
            /**
             * Move certain node in between to the head.
             */
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            /**
             * Pop the current tail.
             */
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.next = null;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the head;
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++size;

                if(size > capacity) {
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }
    }

    public static void main(String[] args) {
        Solution146 sol = new Solution146(2);
        sol.put(1, 1);
        sol.put(2, 2);
        sol.put(3, 3);
        System.out.println(finalMap);
        System.out.println(sol.get(1));
        System.out.println(sol.get(3));

        System.out.println(lruCache);
    }
}
