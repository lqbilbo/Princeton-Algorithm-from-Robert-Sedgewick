package airbnb;

import java.util.*;

public class Solution773 {

    /**
     * 直觉和算法
     *
     * 可以把这个问题看做是寻找最短路径的问题。每个节点都是棋盘的一个状态，如果两个状态可以通过一部操作来完成，就用一条边将这两个
     * 节点连接起来。可以用广度优先算法解决最短路径问题。
     *
     * 在广度优先算法中，可以将各个节点用哈希结构来表示，同时还要找到每个节点的相邻节点。
     * 在 Java 实现中，可以将棋盘转化成一个整数或者直接用 Arrays.deepToString。
     * 为了枚举邻居节点，需要记住0位置。对于每个节点，最多有4个邻居。将棋盘用以为数组表示，则邻居节点距离当前节点(1, -1, C, -C)。
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new ArrayDeque();
        Node start = new Node(board, sr, sc, 0);
        queue.add(start);

        Set<String> seen = new HashSet();
        seen.add(start.boardstring);

        String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.boardstring.equals(target))
                return node.depth;

            for (int[] di: directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;

                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row: node.board)
                    newboard[t++] = row.clone();
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;

                Node nei = new Node(newboard, nei_r, nei_c, node.depth+1);
                if (seen.contains(nei.boardstring))
                    continue;
                queue.add(nei);
                seen.add(nei.boardstring);
            }
        }

        return -1;
    }

    class Node {
        int[][] board;
        String boardstring;
        int zero_r;
        int zero_c;
        int depth;
        Node(int[][] B, int r, int c, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);
            zero_r = r;
            zero_c = c;
            depth = d;
        }
    }

    public static void main(String[] args) {
        Solution773 solution773 = new Solution773();
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        solution773.slidingPuzzle(board);
    }
}
