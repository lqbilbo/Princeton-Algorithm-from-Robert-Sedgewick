package leetcode;

public class Solution794 {

    /**
     * Algorithm
     *
     * We'll count the number of 'X's and 'O's as xCount and oCount.
     *
     * We'll also use a helper function win(player) which checks if that player has won. This checks the 8 horizontal,
     * vertical, or diagonal lines of the board for if there are three in a row equal to that player.
     *
     * After, we just have to check our conditions as stated above.
     *
     * Time and Space Complexity: O(1).
     * @param board
     * @return
     */
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row: board)
            for (char c: row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }

        if (oCount != xCount && oCount != xCount - 1) return false;
        if (win(board, 'X') && oCount != xCount - 1) return false;
        if (win(board, 'O') && oCount != xCount) return false;
        return true;
    }

    public boolean win(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }
}
