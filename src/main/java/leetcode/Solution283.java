package leetcode;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int head = 0;
        int tail = 1;
        while(tail < nums.length) {
            if(nums[head] == 0 && nums[tail] != 0 ) {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                head++;
            } else if(nums[head] != 0) {
                head++;
            }
            tail++;
        }
    }
}
