//On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
// an empty square represented by 0. 
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapp
//ing it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given a puzzle board, return the least number of moves required so that the s
//tate of the board is solved. If it is impossible for the state of the board to b
//e solved, return -1. 
//
// Examples: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
//Input: board = [[3,2,4],[1,5,0]]
//Output: 14
// 
//
// Note: 
//
// 
// board will be a 2 x 3 array as described above. 
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]. 
// 
// Related Topics Breadth-first Search


package com.songying.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingPuzzle{
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;

        //Find sr, sc
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) ->
                (a.heuristic + a.depth) - (b.heuristic + b.depth));
        Node start = new Node(board, sr, sc, 0);
        heap.add(start);

        Map<String, Integer> cost = new HashMap();
        cost.put(start.boardstring, 9999999);

        String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});
        String targetWrong = Arrays.deepToString(new int[][]{{1,2,3}, {5,4,0}});

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.boardstring.equals(target))
                return node.depth;
            if (node.boardstring.equals(targetWrong))
                return -1;
            if (node.depth + node.heuristic > cost.get(node.boardstring))
                continue;

            for (int[] di: directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;

                // If the neighbor is not on the board or wraps incorrectly around rows/cols
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row: node.board)
                    newboard[t++] = row.clone();

                // Swap the elements on the new board
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;

                Node nei = new Node(newboard, nei_r, nei_c, node.depth+1);
                if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
                    continue;
                heap.add(nei);
                cost.put(nei.boardstring, nei.depth + nei.heuristic);
            }
        }

        return -1;
    }
}

    class Node {
        int[][] board;
        String boardstring;
        int heuristic;
        int zero_r;
        int zero_c;
        int depth;
        Node(int[][] B, int zr, int zc, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);

            //Calculate heuristic
            heuristic = 0;
            int R = B.length, C = B[0].length;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    if (board[r][c] == 0) continue;
                    int v = (board[r][c] + R*C - 1) % (R*C);
                    // v/C, v%C: where board[r][c] should go in a solved puzzle
                    heuristic += Math.abs(r - v/C) + Math.abs(c - v%C);
                }
            heuristic /= 2;
            zero_r = zr;
            zero_c = zc;
            depth = d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}