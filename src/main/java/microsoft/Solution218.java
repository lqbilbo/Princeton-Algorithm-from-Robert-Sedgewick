package microsoft;

import java.util.*;

public class Solution218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        int[] rectangle1 = buildings[0];
        ans.add(new ArrayList<>(Arrays.asList(rectangle1[0], rectangle1[2])));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{rectangle1[2], rectangle1[1]});
        int[] rec1 = new int[]{rectangle1[0], 0, rectangle1[1], rectangle1[2]};
        if (buildings.length > 1) {
            for (int i = 1; i < buildings.length; i++) {
                int[] rectangle = buildings[i];
                int[] rec = new int[]{rectangle[0], 0, rectangle[1], rectangle[2]};
                queue.add(new int[]{rectangle[2], rectangle[1]});
                // 1.get the leftmost point
                if (rectangle[2] > rectangle1[2]) {
                    if (!isRectangleOverlap(rec1, rec) && rec[0] != rec1[2]) {
                        ans.add(new ArrayList<>(Arrays.asList(rec1[2], 0)));
                        ans.add(new ArrayList<>(Arrays.asList(rec[0], rec[3])));
                    } else {
                        if (rectangle[0] == rectangle1[0]) ans.remove(ans.size() - 1);
                        ans.add(new ArrayList<>(Arrays.asList(rectangle[0], rectangle[2])));
                        rectangle1[0] = rectangle[0];
                        rectangle1[1] = rectangle[1];
                        rectangle1[2] = rectangle[2];
                    }
                } else {
                    if (!isRectangleOverlap(rec1, rec) && rec[0] != rec1[2]) {
                        // 2.get the rightmost point
                        ans.add(new ArrayList<>(Arrays.asList(rec1[2], 0)));
                        ans.add(new ArrayList<>(Arrays.asList(rec[0], rec[3])));
                        queue.clear();
                        queue.add(new int[]{rectangle[2], rectangle[1]});
                    } else {
                        while (!queue.isEmpty()) {
                            int[] point = queue.poll();
                            if (point[0] == rectangle[2] && !queue.isEmpty()) {
                                int[] leftmost = queue.peek();
                                ans.add(new ArrayList<>(Arrays.asList(leftmost[1], rectangle[2])));
                                if (rectangle[2] == rectangle1[2] || rectangle[0] == rectangle1[0]) ans.remove(ans.size() - 1);
                                queue.add(point);
                                break;
                            }
                        }
                    }
                }

                if (i == buildings.length - 1) {
                    ans.add(new ArrayList<>(Arrays.asList(rectangle[1], 0)));
                }
                rec1[0] = rec[0];
                rec1[2] = rec[2];
                rec1[3] = rec[3];
            }
        } else {
            ans.add(new ArrayList<>(Arrays.asList(rectangle1[1], 0)));
        }

        return ans;
    }

    // if the two rectangles have overlaped area
    boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    public static void main(String[] args) {
//        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};  // case1
//        int[][] buildings = {{0,1,3}};                                           // case2
//        int[][] buildings = {{0,2,3},{2,5,3}};                                   // case3
//        int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};                           // case4 same left
//        int[][] buildings = {{0,3,3},{1,5,3},{2,4,3},{3,7,3}};                   // case5 same height
//        int[][] buildings = {{1,2,1},{2147483646,2147483647,2147483647}};        // case6
//        int[][] buildings = {{2,9,10},{9,12,15}};
        int[][] buildings = {{2,4,7},{2,4,5},{2,4,6}};
        Solution218 solution = new Solution218();
        solution.getSkyline(buildings);
    }
}
