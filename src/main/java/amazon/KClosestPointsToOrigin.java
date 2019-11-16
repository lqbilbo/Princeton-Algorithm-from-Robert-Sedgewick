package amazon;

import java.util.Arrays;

/**
 * 思路：降维，打平为一维数组，排序并获取第K个位置的欧几里得距离distK。获取所有点和distK比较，小于的放入K行2列的二维数组
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; i++) {
            dists[i] = dist(points[i]);
        }

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; i++) {
            if (dist(points[i]) <= distK) {
                ans[t++] = points[i];
            }
        }
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
