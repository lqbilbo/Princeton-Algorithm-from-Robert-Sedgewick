package microsoft;

public class Solution679 {
    private static double eps = 0.00001;

    public boolean judgePoint24(int[] nums) {
        double[] doubleN = new double[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            doubleN[i] = (double)nums[i];
        }
        return helper(doubleN);
    }

    private boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24.0) < eps;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                double[] next = new double[nums.length - 1];
                for (int k = 0, pos = 0; k < nums.length; ++k) {
                    if (k != i && k != j) {
                        next[pos++] = nums[k];
                    }
                }
                double first = nums[i], second = nums[j];
                double[] results = new double[] {first + second, first - second, second - first, first * second};
                for (double last : results) {
                    next[nums.length - 2] = last;
                    if (helper(next)) {
                        return true;
                    }
                }
                if (second >= eps) {
                    next[nums.length - 2] = first / second;
                    if (helper(next)) {
                        return true;
                    }
                }
                if (first >= eps) {
                    next[nums.length - 2] = second / first;
                    if (helper(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
