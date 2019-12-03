package leetcode;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution341 implements Iterator<Integer> {
    class Node{
        int val;
        Node next;
    }

    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    Node head;
    Node dummy;
    public Solution341(List<NestedInteger> nestedList) {
        head = new Node();
        dummy = head;
        recursive(nestedList);
    }

    void recursive(List<NestedInteger> list){
        for(NestedInteger i: list){
            if(i.getInteger() == null){
                recursive(i.getList());
            }else{
                Node n = new Node();
                n.val = i.getInteger();
                dummy.next = n;
                dummy = dummy.next;
            }
        }
    }

    @Override
    public Integer next() {
        Node n = head.next;
        head.next = head.next.next;
        return n.val;
    }

    @Override
    public boolean hasNext() {
        return head.next != null;
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
        NestedInteger nestedInteger = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return 0;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                }, new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
            }
        };
        nestedIntegerList.add(nestedInteger);
        NestedInteger nestedInteger2 = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        };
        nestedIntegerList.add(nestedInteger2);
        nestedIntegerList.add(nestedInteger);

        new Solution341(nestedIntegerList);
    }
}
