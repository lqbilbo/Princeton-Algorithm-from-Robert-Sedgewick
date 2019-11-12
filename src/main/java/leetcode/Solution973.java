package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * python version:
 *
 * class Solution(object):
 *     def kClosest(self, points, K):
 *         points.sort(key = lambda P: P[0]**2 + P[1]**2)
 *         return points[:K]
 */
public class Solution973 {

    public static int[][] kClosest2(int[][] points, int K) {

        int rl = points.length;
        int cl = points[0].length;

        // store the map of distance and index
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0;
        for (int i = 0; i < rl; i++) {
            int[] point = points[i];
            int distance = 0;
            for (int j : point) {
                distance += Math.pow(j, 2);
            }
            if (i == 0) {
                min = distance;
            }
            map.put(distance, i);
            if (distance < min) {
                min = distance;
            }
        }
        Integer dist = map.get(min);
        int[][] res = new int[1][1];
        res[0] = points[dist];
        return res;
    }

    private static int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; i++) {
            dists[i] = dist(points[i]);
        }

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int[] point : points) {
            if (dist(point) <= distK) {
                ans[t++] = point;
            }
        }
        return ans;
    }

    private static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int K = 1;
        int[][] res = kClosest(points, 1);
        System.out.println(res);
    }
}
