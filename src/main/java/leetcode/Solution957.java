package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution957 {
    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[] newCells = new int[8];
        for (int j=0; j<N; j++) {
            for (int i = 0; i < cells.length; i++) {
                if (i>=1) {
                    if (i == cells.length-1) {
                        newCells[i] = cells[i];
                    }
                    if (i<cells.length-1 && cells[i-1] == cells[i+1]) {
                        newCells[i] = 1;
                    } else {
                        newCells[i] = 0;
                    }
                } else {
                    newCells[i] = cells[i];
                }
            }
            cells = newCells;
        }
        return cells;
    }

    /* *********************** Simulation ***************************************************/
    public int[] prisonAfterNDays1(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        int[] res = prisonAfterNDays(cells, N);
        for (int re : res) {
            System.out.print(re + ",");
        }
    }
}
