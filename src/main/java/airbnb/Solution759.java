package airbnb;

import java.util.*;

public class Solution759 {

// Definition for an Interval.
static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

    /**
     *
     * Algorithm
     *
     * When we process the earliest occurring job not yet processed, it occurs at time t, by employee e_id,
     * and it was that employee's e_jx'th job. If anchor < t, then there was a free interval Interval(anchor, t).
     *
     * 直觉和算法
     *
     * 可以这么说我们需要找到没有员工在工作的时间。这段时间一直要持续到有一个员工必须要工作的时候。
     *
     * 所以可以创建一个保存每个员工下一个要工作的时间和关联的工作的堆。当我们从堆中获取到下一个时间时将这个工作赋给那个员工。
     *
     * 维护最近的时间锚anchor，否则我们不知道下一份工作是否与时间重叠
     *
     * 当我们处理马上要来临的工作时（在时间t开始，由员工e_id执行），这是员工的e_jx个工作。如果anchor&lt;t，那么会有一个空闲的时间段(anchor, t)。
     *
     * @param avails
     * @return
     */
    public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> ans = new ArrayList();
        PriorityQueue<Job> pq = new PriorityQueue<Job>(Comparator.comparingInt(a -> avails.get(a.eid).get(a.index).start));
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

    static class Job {
        int eid, index;
        Job(int e, int i) {
            eid = e;
            index = i;
        }
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(4,6);
        Interval interval3 = new Interval(1,3);
        Interval interval4 = new Interval(7,10);
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(interval1,interval2));
        schedule.add(Collections.singletonList(interval3));
        schedule.add(Collections.singletonList(interval4));
        employeeFreeTime(schedule);
    }
}
