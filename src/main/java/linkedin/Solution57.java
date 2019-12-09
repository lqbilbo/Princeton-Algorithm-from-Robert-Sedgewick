package linkedin;

import java.util.LinkedList;

class Solution57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length][intervals[0].length];
        int j = 0;
        for (int i=0; i<intervals.length; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (newInterval[0] >= a && newInterval[0] <= b) {
                newInterval[0] = a;
                ans[j][0] = a;
                continue;
            }
            if (newInterval[1] >= a && newInterval[1] <= b) {
                newInterval[1] = b;
                ans[j][1] = b;
                j++;
                continue;
            }
            if (newInterval[0] <= a && newInterval[1] >= b) {
                continue;
            }
            if (newInterval[0] > b) {
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
                j++;
                continue;
            }
            if (newInterval[1] < a) {
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
                break;
            }
        }
        return ans;
    }

    /**
     * Greedy
     * The idea of greedy algorithm is to pick the locally optimal move at each step,
     * that will lead to the globally optimal solution.
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insertWithGreedy(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) output.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        System.out.println(insert(intervals, newInterval));
    }
}
