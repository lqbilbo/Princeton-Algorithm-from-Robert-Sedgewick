package microsoft;

public class Solution836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = Math.max(rec2[0], rec1[0]);
        int y1 = Math.max(rec2[1], rec1[1]);

        int x2 = Math.min(rec2[2], rec1[2]);
        int y2 = Math.min(rec2[3], rec1[3]);

        return isRectangle(x1, x2, y1, y2);
    }

    private boolean isRectangle(int x1, int x2, int y1, int y2) {
        return x1 - x2 < 0 && (y1 - y2 < 0);
    }

    public boolean isRectangleOverlapWithCheckPosition(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {2,2,3,3};

        Solution836 solution = new Solution836();
        solution.isRectangleOverlap(rec1, rec2);
    }
}
