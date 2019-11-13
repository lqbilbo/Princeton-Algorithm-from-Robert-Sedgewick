package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {

    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(int[][] inter) {

        Interval[] intervals = new Interval[inter.length];
        for(int i = 0; i < inter.length; i++) {
            Interval interval = new Interval(inter[i][0], inter[i][1]);
            intervals[i] = interval;
        }

        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        Arrays.sort(
                intervals,
                new Comparator<Interval>(){
                    public int compare(Interval a, Interval b) {
                        return a.start - b.start;
                    }
                });

        allocator.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i].end);
        }

        return allocator.size();
    }
}
