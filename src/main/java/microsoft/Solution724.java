package microsoft;

public class Solution724 {

    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) return -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int previousSum = nums[0];
        if (sum == previousSum) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (2 * previousSum == sum - nums[i]) {
                return i;
            } else {
                previousSum += nums[i];
            }
        }
        return -1;
    }
}
