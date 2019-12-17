package leetcode;

import java.util.Stack;

/**
 * Queue is FIFO data structure, in which the elements are inserted from one side - [rear] and removed from the other -
 * [front]. The most intuitive way to implement it is with linked lists, but another approach is using stacks.
 * To satisfy FIFO property of a queue we need to keep two stacks. They serve to reverse arrival order of the elements
 * and one of them store the queue elements in their final order.
 */
public class Solution232 {

    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    /** Initialize your data structure here. */
    public Solution232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
