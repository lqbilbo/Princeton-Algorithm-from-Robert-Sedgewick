package microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class Solution252 {

    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> c=(int[] a, int[] b) -> (a[0]-b[0]);
        Arrays.sort(intervals, c);
        for(int i=0; i<intervals.length-1; i++)
            if(intervals[i][1]>intervals[i+1][0]) return false;
        return true;
    }
}
