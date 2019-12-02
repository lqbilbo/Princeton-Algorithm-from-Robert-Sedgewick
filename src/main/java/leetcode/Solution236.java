package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution236 {

    Queue<Integer> queue;
    int count = 0;
    int sum = 0;
    int size;
    /** Initialize your data structure here. */
    public Solution236(int size) {
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

    /* ********************************** Circular Queue with Array ******************************/

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
