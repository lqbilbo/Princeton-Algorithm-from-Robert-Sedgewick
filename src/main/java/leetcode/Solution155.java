package leetcode;

import java.util.*;

public class Solution155 {


    List<Integer> list;
    Map<Integer, Integer> map;
    int count = 0;
    int min = 0;
    /** initialize your data structure here. */
    public Solution155() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        if (list.isEmpty()) {
            min = x;
        }
        list.add(x);
        if (x <= min) min = x;
        map.put(count, x);
        count++;
    }

    public void pop() {
        int x = map.get(count);
        list.remove(x);
        count--;
    }

    public int top() {
        return map.get(count);
    }

    public int getMin() {
        return min;
    }

    /* *****************************use deque ************************************************/

    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public void pushWithDeque(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void popWithDeque() {
        int x = stack.pop();
        if(x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int topWithDeque() {
        return stack.peek();
    }

    public int getMinWithDeque() {
        return minStack.peek();
    }
}
