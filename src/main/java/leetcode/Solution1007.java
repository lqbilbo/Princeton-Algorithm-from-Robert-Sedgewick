package leetcode;

public class Solution1007 {

    public static int check(int x, int[] A, int[] B, int n) {
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rotations_a++;
            else if (B[i] != x) rotations_b++;
        }
        return Math.min(rotations_a, rotations_b);
    }

    /**
     * Algorithm
     *
     * Pick up the first element. It has two sides: A[0] and B[0].
     * Check if one could make all elements in A row or B row to be equal to A[0]. If yes, return the minimum number of
     * rotations needed.
     * Check if one could make all elements in A row or B row to be equal to B[0]. If yes, return the minimum number of
     * rotations needed.
     * Otherwise return -1.
     * Time complexity : O(N) since here one iterates over the arrays not more than two times.
     * Space complexity : O(1) since it's a constant space solution.
     * @param A
     * @param B
     * @return
     */
    public static int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        if (rotations != -1 || A[0] == B[0]) return rotations;
        else return check(B[0], B, A, n);
    }
    public static void main(String[] args) {
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        minDominoRotations(A, B);
    }
}
