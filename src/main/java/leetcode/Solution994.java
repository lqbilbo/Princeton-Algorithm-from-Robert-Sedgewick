package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 变体：int[][] -> List<List<Integer>>
 */
public class Solution994 {

    static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    /**
     * intuition: bfs
     * We can use a breadth-first search to model this process. Because we always explore nodes (oranges) with the
     * smallest depth first, we're guaranteed that each orange that becomes rotten does so with the lowest possible
     * depth number. We should also check that at the end, there are no fresh oranges left.Complexity Analysis.
     *
     * Time Complexity: O(N)O(N), where NN is the number of cells in the grid.
     * Space Complexity: O(N)O(N).
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        if (grid == null)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int cnt = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i=0; i<sz; i++) {
                int[] pos = q.poll();
                for (int[] dir: dirs) {
                    int x = pos[0]+dir[0];
                    int y = pos[1]+dir[1];
                    if (x>=0 && x<m && y>=0 && y<n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x,y});
                    }
                }
            }
            cnt++;
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return cnt-1;
    }

    public static void main(String[] args) {
        int[] row1 = {2,1,1};
        int[] row2 = {1,1,0};
        int[] row3 = {0,1,1};
        int[][] grid = {row1,row2,row3};
        System.out.println(orangesRotting(grid));
    }

}
