package leetcode;

public class Solution152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newMin = min(nums[i], nums[i] * min, nums[i] * max);
            int newMax = max(nums[i], nums[i] * min, nums[i] * max);
            res = max(res, newMin, newMax);
            max = newMax;
            min = newMin;
        }
        return res;
    }
    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
