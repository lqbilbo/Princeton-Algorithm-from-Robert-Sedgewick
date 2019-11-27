package leetcode;

class Solution713 {

    /**
     * intuition: sliding window
     * For each right, call opt(right) the smallest left so that the product of the subarray nums[left] * nums[left + 1]
     * * ... * nums[right] is less than k. opt is a monotone increasing function, so we can use a sliding window.
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        numSubarrayProductLessThanK(nums, k);
    }
}
