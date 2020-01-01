package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution56 {

    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

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

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    /* class Solution {
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        int row = intervals.length;
        int col = 2;
        List<Interval> intervalArr = new ArrayList<>();
        int count = 0;
        for (int[] r : intervals) {
            intervalArr.add(new Interval(r[0], r[1]));
        }
        Collections.sort(intervalArr, (o1, o2) -> o1.start - o2.start);
        int start = intervalArr.get(0).start, end = intervalArr.get(0).end;
        int[][] ans = new int[row][col];
        for (int i = 1; i < row; i++) {
            if (intervalArr.get(i).start > end) {
                ans[count][0] = intervalArr.get(i).start;
                ans[count][1] = intervalArr.get(i).end;
            } else {
                ans[count][0] = Math.min(start, intervals[i][0]);
                ans[count][1] = Math.max(end, intervals[i][1]);
            }
            start = ans[count][0];
            end = ans[count][1];
            count++;
        }
        return ans;
    }
}*/

}
