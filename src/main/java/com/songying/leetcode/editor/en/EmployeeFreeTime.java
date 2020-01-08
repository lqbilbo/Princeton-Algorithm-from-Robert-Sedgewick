//We are given a list schedule of employees, which represents the working time f
//or each employee. 
//
// Each employee has a list of non-overlapping Intervals, and these intervals ar
//e in sorted order. 
//
// Return the list of finite intervals representing common, positive-length free
// time for all employees, also in sorted order. 
//
// (Even though we are representing Intervals in the form [x, y], the objects in
//side are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, 
//schedule[0][0].end = 2, and schedule[0][0][0] is not defined). Also, we wouldn't
// include intervals like [5, 5] in our answer, as they have zero length. 
//
// 
// Example 1: 
//
// 
//Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//Output: [[3,4]]
//Explanation: There are a total of three employees, and all common
//free time intervals would be [-inf, 1], [3, 4], [10, inf].
//We discard any intervals that contain inf as they aren't finite.
// 
//
// Example 2: 
//
// 
//Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//Output: [[5,6],[7,9]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= schedule.length , schedule[i].length <= 50 
// 0 <= schedule[i].start < schedule[i].end <= 10^8 
// 
// Related Topics Heap Greedy


package com.songying.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime{
    public static void main(String[] args) {
        Solution solution = new EmployeeFreeTime().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

class Solution {

    public List<Interval> employeeFreeTimeWithEvents(List<List<Interval>> avails) {
        int OPEN = 0, CLOSE = 1;

        List<int[]> events = new ArrayList();
        for (List<Interval> employee: avails)
            for (Interval iv: employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, bal = 0;
        for (int[] event: events) {
            // event[0] = time, event[1] = command
            if (bal == 0 && prev >= 0)
                ans.add(new Interval(prev, event[0]));
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> ans = new ArrayList();
        PriorityQueue<Job> pq = new PriorityQueue<Job>((a, b) ->
                avails.get(a.eid).get(a.index).start -
                        avails.get(b.eid).get(b.index).start);
        int ei = 0, anchor = Integer.MAX_VALUE;

        for (List<Interval> employee: avails) {
            pq.offer(new Job(ei++, 0));
            anchor = Math.min(anchor, employee.get(0).start);
        }

        while (!pq.isEmpty()) {
            Job job = pq.poll();
            Interval iv = avails.get(job.eid).get(job.index);
            if (anchor < iv.start)
                ans.add(new Interval(anchor, iv.start));
            anchor = Math.max(anchor, iv.end);
            if (++job.index < avails.get(job.eid).size())
                pq.offer(job);
        }

        return ans;
    }
}

class Job {
    int eid, index;
    Job(int e, int i) {
        eid = e;
        index = i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}