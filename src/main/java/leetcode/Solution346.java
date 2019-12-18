package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution346 {

    Queue<Integer> queue;
    int count = 0;
    int sum = 0;
    int size;
    /** Initialize your data structure here. */
    public Solution346(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (count == size) {
            sum -= queue.poll();
            count--;
        }
        queue.offer(val);
        count++;
        sum += val;
        return (double) sum / count;
    }

    /* ********************************** Double-ended queue *************************************/

    int windowSum = 0, count1 = 0;
    Deque queue1 = new ArrayDeque<Integer>();

    /**
     * Deques are a generalization of stacks and queues (the name is pronounced deck and is short for double-ended queue).
     * Deques support thread-safe, memory efficient appends and pops from either side of the deque with approximately
     * the same O(1) performance in either direction.
     * @param val
     * @return
     */
    public double next1(int val) {
        ++count1;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }

    /* ********************************** Circular Queue with Array ******************************/

    /**
     * The major advantage of circular queue is that by adding a new element to a full circular queue, it automatically
     * discards the oldest element. Unlike deque, we do not need to explicitly remove the oldest element.
     * Another advantage of circular queue is that a single index suffices to keep track of both ends of the queue,
     * unlike deque where we have to keep a pointer for each end.
     */
    /*class MovingAverage {
        int size, head = 0, windowSum = 0, count = 0;
        int[] queue;
        public MovingAverage(int size) {
            this.size = size;
            queue = new int[size];
        }
​
        public double next(int val) {
            ++count;
            // calculate the new sum by shifting the window
            int tail = (head + 1) % size;
            windowSum = windowSum - queue[tail] + val;
            // move on to the next head
            head = (head + 1) % size;
            queue[head] = val;
            return windowSum * 1.0 / Math.min(size, count);
        }
    }*/

}
