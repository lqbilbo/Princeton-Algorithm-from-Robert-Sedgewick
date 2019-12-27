package microsoft;

public class Solution153 {
    public int findMin(int[] nums) {
        int hit = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                hit = i;
            }
        }
        if (hit == 0) {
            return nums[0];
        } else {
            return nums[hit];
        }
    }
}
